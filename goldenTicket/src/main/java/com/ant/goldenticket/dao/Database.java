package com.ant.goldenticket.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Database
{
	//All'interno di questa classe abbiamo applicato il pattern FACADE
	//Questo pattern strutturale consiste nel nascondere con una facciata
	//delle classi/interfacce esterne a tutto il resto del programma.
	//Con NASCONDERE intendiamo che d'ora in poi chiunque dovr� parlare con MYSQL si rivolger� a noi tramite
	//i metodi ROW, ROWS e UPDATE.
	//Solo la classe DATABASE conoscer� le modalit� con cui il programma parla con il DB: Connection, PreparedStatement, ResultSet
	//Quindi questa classe fa da facciata e comunica con il resto del programma utilizzando oggetti e strutture di dati (MAPPE)
	//conosciute da Java.
	//Tutta la parte relativa a quelle classi strane viene nascosta e utilizzata soltando qui.
	
	//Quando noi chiamiamo il metodo rows non conosciamo il processo ma solo che data una query ci riporta una mappa corrispondente
	//alla tabella del database che ottiene tramite la query stessa.
	//La logica della facade � questa, nascondere il processo per mostrare solo il risultato.
	//Chi interagisce con la facade? I vari DAO come DAOClienti
	
	//Il client si rivolger� a Database il quale a sua volta andr� a mascherare tutto quello che c'� sotto,
	//ossia Connection, Statement e ResultSet.
	//La freccia tratteggiata che si vede nella dispensa significa 'utilizza'.
	//Siccome Connection, Statement e ResultSet sono molto connessi tra loro, attraverso la Facade facciamo in modo che
	//tale connessione sia nascosta e che il client parli direttamente con la classe DB.
	
	//Rispetto alla logica usata finora, diciamo che questa modalit� di lavoro
	//fa si che una classe gestisca tutte le modalit� che stanno dietro
	//al suo funzionamento cos� che il programmatore non debba gestirle direttamente.
	//Non mascheriamo come nell'incapsulamento ma solo a livello di utilizzo.
	//Non si tratta di sicurezza ma di sbatta minore per i programmatori.
	//Noi da qui in poi non sapremo pi� cosa sono Connection etc.
	//ma ci rifaremo solo al metodo rows, row e update per comunicare con il db.
	//Un po' come abbiamo fatto finora con ArrayList, List, etc.
	
	//Creiamo qui una classe Database in modo da non doverlo pi� fare per ogni progetto
	//In questa classe ci saranno tutte le azioni relative all'oggetto Database
	//come stabilire una connessione, etc.
	private Connection c;
	
	public Database(String nomeDB, String user, String password)
    {
        String timeZone = "useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false&amp";
        String percorso = "jdbc:mysql://localhost:3306/"+ nomeDB + "?" 
                          + timeZone + "&useSSL=false";
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.c = DriverManager.getConnection(percorso, user, password);
        }
        catch(Exception e)
        {
            System.out.println(	"Catch nel costruttore della classe Database\n"	+
            					"Controlla build path, username, password"		);
            e.printStackTrace();
        }
    }//Fine di costruttore
	
	//Creiamo un metodo che trasforma le righe di un DB in mappe
	/**
	 * Metodo per trasformare le righe della tabella di un DB in una mappa
	 * Ogni mappa corrisponde a un record della tabella.
	 * Ogni mappa sar� composta dalle chiavi corrispondenti alla label della colonna
	 * e dai valori ad essa associato.
	 * @param la query da inviare al db
	 * @param String... params ->	params conterr� il valore da sostituire ai segnaposto della nostra query
	 * 								questo valore pu� variare in base alla query: 
	 * 								params � di tipo [] -> � un vettore di String
	 * 								... ->	i tre punti indicano che params non deve arrivare per forza ma � un
	 * 										parametro opzionale. Potranno arrovare altre 0 String o altre n String
	 * 										tutte quelle che arriveranno verranno inserite dentro a params che si
	 * 										comporter� come un vettore di String
	 * 								QUESTO STRUMENTO SI CHIAMA VARARGS -> Variable Arguments
	 * 								I parametri oltre alla query verranno automaticamente raggruppati dentro a params
	 * 								I parametri vengono passati separati da una ","
	 * @return	una mappa contenente la tabella del DB sotto forma di mappa!
	 */
	public List<Map<String, String>> rows(String query, String... params)
	{
		//Ogni riga se ci pensiamo � una coppia chiave valore dove la chiave � la label della colonna
		//e il valore � quello al suo interno
		List<Map<String, String>> ris = new ArrayList<Map<String, String>>();
		
		try
		{
			//Prima di tutto eseguiamo la query che ci viene passata come parametro
			PreparedStatement p = c.prepareStatement(query);
			
			//Ora che abbiamo i params andiamo a sostituirli alla query
			//Deve arrivare tutto sotto forma di String, poi SQL interpreter� la String
			//e capir� da solo che si tratta di un numero
			//Se non avessimo parametri, params.length sar� 0 e il ciclo non parte
			//i + 1 serve perch� io devo partire dal primo parametro
			//ma l'indice i parte da zero
			//Se ci sono pi� parametri rispetto ai segnaposto della query, qui creer� un'eccezione
			//che ci riporter� nel catch
			for(int i = 0; i < params.length; i++)
				p.setString(i + 1, params[i]);
			
			//Otteniamo la tabella
			ResultSet rs = p.executeQuery();
			
			//Cicliamo tutte le righe della tabella
			//1 riga = 1 record
			while(rs.next())
			{
				//Creo una mappa che corrisponde alla singola riga
				//In questo caso posso usare una LinkedHashMap
				//Le chiavi saranno le label della tabella
				//I valori saranno i valori veri e propri dei campi
				//Le chiavi saranno sempre uguali mentre i valori cambiano
				//in base alla riga che guardo
				Map<String, String> riga = new LinkedHashMap<String, String>();
				
				//getMetaData().getColumnCount() restituisce il numero delle colonne della tabella
				//i = 1 indica che partiamo dalla prima colonna perch� su sql non esiste la colonna
				//numero zero!
				for(int i = 1; i <= rs.getMetaData().getColumnCount(); i++)
				{
					//put() vuole 2 parametri:
					//In rs.getMetaData().getColumnLabel(i).toLowerCase()
					//In questo modo siamo sicuri che il nome della colonna arrivi in minuscolo.
					//Cos� tutte le chiavi sono in minuscolo.
					//ContainsKey() infatti fa differenza tra maiuscolo e minuscolo.
					//In questo modo stiamo tranquilli che non ci siano problemi.
					riga.put(	rs.getMetaData().getColumnLabel(i),	//Chiave -> label
								rs.getString(i));					//Valore
					
					
				}//Fine di for
				
				//Aggiungiamo la mappa appena creata all'interno dell'ArrayList di Mappe
				//Siamo fuori dal for ma sempre dentro al while perch� l'operazione
				//viene fatta per ogni riga della nostra tabella.
				//Una volta aggiunta, passa alla riga successiva -> rs.next()
				ris.add(riga);
				
				//il while cicla in verticale per ogni riga della tabella,
				//mentre il for cicla in orizzontale per ogni
				//colonna dentro la quale si trovano i valori
				//da assegnare alle chiavi
				
			}//Fine di while
		}
		catch(Exception e)
		{
			System.out.println("Catch del metodo rows della classe Database in Utility");
			e.printStackTrace();
		}
		
		return ris;
	}//Fine di rows
	
	/**
	 * Il metodo row prende una tabella e restituisce solo la prima riga sotto forma di mappa
	 * Pu� essere utile quando sappiamo che la query restituisce un solo record come nel caso
	 * della ricerca per id, funzioni di gruppo, etc.
	 * @param query
	 * @param params
	 * @return una mappa che rappresenta una riga della tabella
	 */
	public Map<String, String> row(String query, String... params)
	{
		try
		{
			//Invece di rifare tutto, invochiamo rows, gli passiamo tutti i parametri
			//e richiediamo solo il primo valore, ossia la prima riga .get(0)
			//Prendo tutte le righe, da tutte le righe, prendo solo il primo elemento, la prima riga
			return	rows(query, params).get(0);
		}
		catch(Exception e)
		{
			//Creo un try catch perch� la query potrebbe non restituire nulla
			//La tabella potrebbe essere vuota oppure la query potrebbe essere sbagliata
			return null;
		}
	}//Fine di row()
	
	/**
	 * Il metodo viene utilizzato per tutte le query di modifica dei dati all'interno del DB
	 * Riceve una query e dei parametri che corrispondono ai nuovi valori
	 * All'interno del metodo la query viene aggiornata sostituendo i segnaposto con i nuovi valori
	 * passati dai parametri e infine esegue la query
	 * Se l'update va a buon fine restituisce true, altrimenti false
	 * @param query
	 * @param params
	 * @return true se l'update va a buon fine, false se ci sono problemi
	 */
	public boolean update(String query, String... params)
	{
		try
		{
			PreparedStatement p = c.prepareStatement(query);
			
			for(int i = 0; i < params.length; i++)
			{
				p.setString(i + 1, params[i]);
			}
			
			p.executeUpdate();
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Catch del metodo update di Database in Utility");
			e.printStackTrace();
			return false;
		}
	}//Fine di update
}