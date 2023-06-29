package com.ant.goldenticket.entities;

import java.lang.reflect.Method;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

//Questa classe sar� la base di tutte le classi dei nostri futuri progetti
public abstract class Entity
{
	//Entity avr� solo la propriet� private id
	private int id;
	
	public Entity()
	{
		//Costruttore vuoto di Entity
	}
	
	public Entity(int id)
	{
		//Costruttore di Entity al quale passo un valore id
		this.id = id;
	}

	//Get/Set
	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}
	
	/**
	 * Il metodo toMap trasformer� l'oggetto di tipo Entity in una mappa
	 * Entity � astratta, quindi il metodo serve per trasformare anche i figli di Entity
	 * I nomi delle propriet� saranno utilizzate come chiavi
	 * I valori delle chiavi saranno i valori veri e propri delle propriet�
	 * @return una mappa (HashMap) corrispondente all'oggetto di tipo Entity
	 */
	public Map<String, String> toMap()
	{
		//Usiamo una HashMap perch� successivamente torner� utile
		Map<String, String> ris = new HashMap<String, String>();
		
		//Introduciamo il concetto di JAVA REFLECTION
		//La capacit� di un oggetto Java di riflettere su se stesso e di guardare a propriet�
		//e metodi contenuti al proprio interno.
		//Attraverso la Java reflection avremo accesso alle propriet� e ai metodi di noi stessi!
		//Apparentemente questo sembra non avere molto senso perch� Entity contiene solo id,
		//ma quando Entity generer� figli, ognuno di loro avr� accesso alle
		//sue propriet� e ai suoi metodi.
		//Si tratta di un modo per dire al programma come comportarsi su propriet� e metodi che ora
		//non conosciamo ma che sappiamo, prima o poi, ci saranno!
		
		for(Method m : this.getClass().getMethods())
		{
			//Cicliamo tutti i metodi e teniamo in considerazione tutti quelli che iniziano con
			//get e che sono diversi da getClass perch� a noi non interessa.
			if(	m.getName().startsWith("get")	&&
				!m.getName().equalsIgnoreCase("getClass"))
			{
				//Mettiamo un try/catch perch� il metodo invoke() pu� generare un'eccezione
				try
				{
					//Una volta che abbiamo trovato il metodo che ci interessa
					//iniziamo a riempire la mappa
					//La chiave sar� il nome del metodo senza il get -> getNome() diventer� nome
					//m.getName() restituisce il nome del metodo
					//subString() crea una stringa dalla precedente partendo dall'indice che gli viene dato
					//Partendo da getNome -> crea una stringa partendo dal 4� carattere, ossia n -> nome
					//Per approfondire meglio, basta andare col mouse sulla scritta substring()
					String key = m.getName().substring(3).toLowerCase();
					//Il valore sar� il valore della propriet�, ossia il return del metodo get()
					//Il risultato del metodo get()
					//m.invoke() restituisce un object.
					//m -> � un metodo
					//invoke() ->	richiama un metodo e lo applichiamo a this perch� un metodo deve
					//				essere applicato a un oggetto
					//Concatenando il valore a un "" trasforma tutto in una String
					String value = m.invoke(this) + "";
					//Chiave e valore verranno poi inseriti all'interno della mappa!
					ris.put(key, value);
					//Questo metodo si basa sulla COC
					//Convention Over Configuration -> in base a come lavoriamo, sappiamo che
					//il metodo get() restituisce sempre il valore della propriet�.
					//Se cos� non fosse, questa struttura non funzionerebbe.
					//Per questo motivo � importante seguire delle convenzioni specifiche!
				}
				catch(Exception e)
				{
					//L'eccezione deriva da invoke perch� il metodo ha bisogno di parametri
					//Siccome il parametro � il valore che stiamo prendendo, questo catch non si
					//verificher� mai ma abbiamo bisogno di gestire l'eccezione.
					System.out.println("Eccezione del metodo toMap() in Entity");
					e.printStackTrace();
				}
			}//Fine di if
			else if(m.getName().startsWith("is"))
			{
				//Questo else if serve per i get delle propriet� di tipo boolean
				//I get delle propriet� boolean vengono generati come isPROPRIETA quindi
				//il primo if sarebbe inefficace e dobbiamo specificare l'eventualit�
				try
				{
					//Rispetto a prima, cambia solo che la substring inizia dall'indice 2
					//perch� invece di get dovr� eliminare la scritta is dal nome del metodo
					//isPromosso() -> promosso
					String key = m.getName().substring(2).toLowerCase();
					String value = m.invoke(this) + "";
					ris.put(key, value);
				}
				catch(Exception e)
				{
					System.out.println("Eccezione del metodo toMap() in Entity");
					e.printStackTrace();
				}
			}//Fine di elseIf
		}//Fine di for
		
		return ris;
	}//Fine del metodo toMap()
	
	//Dopo il metodo toMap() creiamo un metodo fromMap()
	//Che si comporta al contrario del precedente
	/**
	 * Questo metodo riceve una mappa come parametro e valorizza le propriet�
	 * dell'oggetto con i valori contenuti in essa. Infine ritorna l'oggetto stesso
	 * Prendiamo una mappa e creiamo l'oggetto valorizzandone i valori in base alla mappa.
	 * @param map
	 * @return
	 */
	/*public Entity fromMap(Map<String, String> map)
	{
		//Come prima, cicliamo tutti i metodi dell'oggetto
		for(Method m : this.getClass().getMethods())
		{
			//Prendiamo tutti i metodi il cui nome inizia con set e hanno esattamente un parametro
			//Cos� abbiamo una sicurezza in pi�.
			//Questa condizione m.getParameterCount() == 1 pu� essere messa anche nel metodo toMap()
			//con il valore 0 -> m.getParameterCount() == 0 perch� i get() non hanno parametri.
			if(m.getName().startsWith("set") && m.getParameterCount() == 1)
			{
				//Ora dobbiamo capire in quale set() ci troviamo.
				//Andiamo a leggere il valore della propriet� partendo dal set ed eliminando la
				//scritta set con il substring(3) -> setId() -> Id.toLowerCase() -> id
				String nomeProprieta = m.getName().substring(3).toLowerCase();
				
				//Controlliamo ora se all'interno della mappa esiste una chiave che si chiama come
				//il setter senza le prime 3 lettere.
				//Controllo se all'interno della mappa esiste la chiave corrispondente a nomeProprieta
				//setNome() -> Nome -> nome -> controllo se nella mappa esiste la chiave "nome"
				if(map.containsKey(nomeProprieta))
				{
					//Ora sono sicuro che la chiave esiste e corrisponde a nomeProprieta
					//Devo prendere il valore
					String valore = map.get(nomeProprieta);
					//Ora devo inserirlo all'interno della propriet�
					//Prima per estrapolare il valore abbiamo usato invoke() del metodo m
					//ora dobbiamo fare il contrario
					try
					{
						//Ora dobbiamo ragionare in modo da capire il tipo di parametro
						//che viene passato ai vari set perch� le propriet� possono essere di tipo diverso
						//String, int, etc.
						//Stavolta non possiamo guardare al return perch� i set() sono void.
						//In questo modo andiamo a prendere il tipo del primo e unico parametro
						//del metodo e lo analizziamo
						//m.getParameters()[0] -> di tutti i parametri prende il primo
						//.getType() -> del primo prende il tipo String
						//getSimpleName() -> del tipo prende il nome "String"
						//toLowerCase() -> mette in minuscolo string
						String tipo = m.getParameters()[0].getType().getSimpleName().toLowerCase();
						switch(tipo)
						{
							//A seconda del tipo andiamo a sistemare il valore
							case "string"	:
								m.invoke(this, valore);
							break;
							
							case "int"	:
								m.invoke(this, Integer.parseInt(valore));
							break;
							
							case "double"	:
								m.invoke(this, Double.parseDouble(valore));
							break;
							
							case "date"	:
								m.invoke(this, Date.valueOf(valore));
							break;
							
							case "boolean"	:
								//Per i boolean dobbiamo pensare a tutti i modi in cui
								//potrebbero arrivare i valori boolean:
								//Dal db ad esempio arrivano 1 e 0
								//Dall'utente potrebbe arrivare si, s�, true, etc.
								m.invoke(this,	valore.equals("1")				||
												valore.equalsIgnoreCase("true")	||
												valore.equalsIgnoreCase("vero")	||
												valore.equalsIgnoreCase("si")	||
												valore.equalsIgnoreCase("s�"))	;
							break;
							
							default	:
								//Se il tipo non � tra quelli dello switch, lo stampiamo in console.
								//System.err stampa in rosso anzich� in nero in console!
								System.err.println("Nel fromMap() non ho riconosciuto il tipo " + tipo);
							break;
						
						}//Fine di switch
					}
					catch(Exception e)
					{
						System.out.println("Catch del metodo fromMap() di Entity");
						e.printStackTrace();
					}
					
				}//Fine di if
				
			}//Fine di if
			
		}//Fine di for
		
		//Alla fine di tutto, facciamo ritornare l'oggetto da cui � partito il metodo fromMap()
		//ma stavolta l'oggetto avr� i valori delle propriet� impostati
		return this;
		
	}//Fine del metodo fromMap()
	
	//A questo punto possiamo creare un metodo toString() dell'oggetto Entity che attraverso il metodo toMap()
	//non restituir� solo il valore dell'id ma anche di tutte le propriet� che ancora non ci sono
	//ma che evidentemente arriveranno in futuro*/
	
	//////////////////////////////////////////////////////////////////
	public void fromMap(Map<String, String> map) {
		// ciclo per le chiavi delle mappe
		for (String key : map.keySet()) {
			// per ogni chiave della mappa ciclo tutti i metodi esistenti nella classe
			// concreta dell'oggetto in questione
			for (Method m : this.getClass().getMethods()) {//
				//prendi classe concreta che stai gestendo ora
				// ogni m è singolo metodo della classe
				if (m.getName().equalsIgnoreCase("set" + key)) {//metodi sono setNome,setID
					// se nome chiave = nome colonna di db e = a proprietà
					// allora setNome esisterà in classe
					try {//se trova corrispondenza analizza il tipo di parametri utilizzati
						// estrapolare il nome del tipo di ritorno del metodo m
						// lo confronto con STRING
						switch (m.getParameterTypes()[0].getSimpleName()) {
						// getPTypes -> ritorna il tipo formale[0] e lo rende testo
						// la classe si auto legge, grazie a Java Reflection
						// Classe guarda i suoi tipi, i suoi contenuti, parametri...
						case "String"	:
							m.invoke(this, map.get(key));
						break;
						
						case "int"	:
							m.invoke(this, Integer.parseInt(map.get(key)));
						break;
						
						case "double"	:
							m.invoke(this, Double.parseDouble(map.get(key)));
						break;
						
						case "date"	:
							m.invoke(this, Date.valueOf(map.get(key)));
						break;
						
						case "boolean"	:
							//Per i boolean dobbiamo pensare a tutti i modi in cui
							//potrebbero arrivare i valori boolean:
							//Dal db ad esempio arrivano 1 e 0
							//Dall'utente potrebbe arrivare si, s�, true, etc.
							m.invoke(this,	map.get(key).equals("1")		||
									map.get(key).equalsIgnoreCase("true")	||
									map.get(key).equalsIgnoreCase("vero")	||
									map.get(key).equalsIgnoreCase("si")	    ||
									map.get(key).equalsIgnoreCase("s�"))	;
						break;
						
						default	:
							//Se il tipo non � tra quelli dello switch, lo stampiamo in console.
							//System.err stampa in rosso anzich� in nero in console!
							System.err.println("Nel fromMap() non ho riconosciuto il tipo " + 
							m.getParameterTypes()[0].getSimpleName());
						break;
						}
						// invoke utilizza il set e passa il valore quindi le mie proprietà
						// saranno visualizzate
					} catch (Exception e) {
						System.out.println("Problema di tipologia");
					}
				}
			}
		}
	}
	public String toString()
	{
		//Iniziamo con una String che contiene il valore di id preso dall'oggetto
		String ris = "Id: " + id + "\n";
		
		//Poi trasformiamo l'oggetto in una mappa attraverso il metodo toMap()
		Map<String, String> mappa = toMap();
		
		//Cicliamo tutte le chiavi all'interno del keySet()
		//e concateniamo a ris le varie coppie chiave valore corrispondenti al
		//nome della propriet� e valore della propriet�.
		//Concateniamo a ris tutto quello che non � id, visto che lo abbiamo gi�
		//keySet() restituisce un SET -> un set � un vettore senza indice.
		//Un set � un insieme dello stesso tipo, senza duplicati (perch� non posso avere due chiavi
		//uguali nelle mappe), non ordinato, quindi non posso ciclarlo con il
		//for perch� non ha un indice e devo ricorrere per forza al for each!
		for(String key : mappa.keySet())
			if(!key.equals("id"))
				ris += key + " : " + mappa.get(key) + "\n";
		
		//Alla fine, mettiamo un semplice separatore.
		ris += "------------------------\n";
		return ris;
	}//Fine di toString()
}