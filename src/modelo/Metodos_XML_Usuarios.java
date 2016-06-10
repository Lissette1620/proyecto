/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import vista.FRM_Usuario;
import vista.FRM_VentanaPrincipal;


/**
 *
 * @author Lissette
 */
public class Metodos_XML_Usuarios {
    FRM_Usuario ventana;
    DocumentBuilderFactory factory;
    DocumentBuilder builder;
    DOMImplementation implementation;
    Document document;
    ArrayList titulos;
    ArrayList valores;
    Element raiz,principal;
    public String arregloInformacion[];
    Source source;
    Result result;
    Result console;
    Transformer transformer;
    String nombreArchivo;
    String tipo;

public Metodos_XML_Usuarios(FRM_Usuario ventana)
{
        this.ventana=ventana;  
        nombreArchivo="Usuario";
        
        if(cargarXML())
        {
           ventana.mostrarMensaje("Ya existe un archivo XML creado, ya fue cargado y puede proceder a utilizarlo");
        }
        else
        {
            crearXML();
            ventana.mostrarMensaje("No existía un archivo XML creado, ya fue creado y puede proceder a utilizarlo");
        }
        
        arregloInformacion=new String[5];
        titulos = new ArrayList();
        valores = new ArrayList();
}
public void crearXML() //Método nuevo en pruebas
    {
        factory = DocumentBuilderFactory.newInstance();
        try {
            builder = factory.newDocumentBuilder();
            implementation = builder.getDOMImplementation();
            document = implementation.createDocument(null, "xml", null);
            document.setXmlVersion("1.0");
            source = new DOMSource(document);
            result = new StreamResult(new java.io.File(nombreArchivo+".xml"));
 
            console = new StreamResult(System.out);
 
            transformer = TransformerFactory.newInstance().newTransformer();
 
            transformer.transform(source, result);
            transformer.transform(source, console);
 
        } catch (Exception e) {
            System.err.println("Error al crear el archivo XML: " + e);
        }
    }
    public boolean cargarXML() //Método nuevo en pruebas
    {
        boolean cargo=false;
        try {
        
            File fXmlFile = new File(nombreArchivo+".xml");
            factory = DocumentBuilderFactory.newInstance();
            builder = factory.newDocumentBuilder();
            document = builder.parse(fXmlFile);
            document.getDocumentElement().normalize();
            cargo=true;
            
            NodeList nList = document.getElementsByTagName("Usuario");
            Node nNode = nList.item(0);
            raiz = (Element) nNode;
                
        } catch (Exception e) {
            System.out.println("Error al cargar el archivo XML"+e);
        }
        return cargo;
    } 
    public void guardarEnXML(String arregloInformacion[])//Método nuevo en pruebas
    {
        try{

            raiz = document.createElement("Usuario");
            principal = document.createElement("Usuario");
            document.getDocumentElement().appendChild(raiz);
            
            Element valor1 = document.createElement("nombre");
            Text text = document.createTextNode(arregloInformacion[0]);
            Element valor2 = document.createElement("contrasena");
            Text text2 = document.createTextNode(arregloInformacion[1]);
           
            raiz.appendChild(valor1);
            valor1.appendChild(text);
            raiz.appendChild(valor2);
            valor2.appendChild(text2);
            
            
            source = new DOMSource(document);
            result = new StreamResult(new java.io.File(nombreArchivo+".xml"));
            console = new StreamResult(System.out);
            transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
            transformer.transform(source, console);
            
            }
        catch (Exception e) 
        {
            System.err.println("Error al guardar: " + e);
        }
    }
    public void crearArchivo(String nombreArchivo) 
    {
        try{
            factory = DocumentBuilderFactory.newInstance();
            builder = factory.newDocumentBuilder();
            implementation = builder.getDOMImplementation();
            document = implementation.createDocument(null, nombreArchivo, null);
            document.setXmlVersion("1.0");
            raiz = document.getDocumentElement();
            Source source = new DOMSource(document);
            Result result = new StreamResult(new java.io.File(nombreArchivo+".xml")); 
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
            System.out.println("Archivo XML creado con el nombre: "+nombreArchivo);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Metodos_XML_Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        
        } catch (TransformerException ex) {
            Logger.getLogger(Metodos_XML_Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    public boolean consultarInformacionDelXml(String nombre)
    { 
         Element raiz = document.getDocumentElement();
         NodeList listaDeItems = raiz.getElementsByTagName("Usuario");
         Node tag=null,datoContenido=null;

         boolean itemEncontrado=false,tituloNombre=false;
         int contador=0;

         for(int contadorItems=0; contadorItems<listaDeItems.getLength(); contadorItems++) 
         {   
             Node item = listaDeItems.item(contadorItems);
             NodeList datosItem = item.getChildNodes();
             for(int contadorTags=0; contadorTags<datosItem.getLength(); contadorTags++) 
             {           
                 tag = datosItem.item(contadorTags); 
                 datoContenido = tag.getFirstChild();

                 if(tag.getNodeName().equals("nombre") && datoContenido.getNodeValue().equals(""+nombre))
                 {
                    itemEncontrado=true;     
                 }
                 if(itemEncontrado && contador<2)
                 {
                    arregloInformacion[contador]=datoContenido.getNodeValue();
                    contador++;
                 }
             }

         }
         return itemEncontrado;
    }
     public boolean consultarInformacionDelXmlC(String contrasena)
    { 
         Element raiz = document.getDocumentElement();
         NodeList listaDeItems = raiz.getElementsByTagName("Usuario");
         Node tag=null,datoContenido=null;

         boolean itemEncontrado=false,tituloContrasena=false;
         int contador=0;

         for(int contadorItems=0; contadorItems<listaDeItems.getLength(); contadorItems++) 
         {   
             Node item = listaDeItems.item(contadorItems);
             NodeList datosItem = item.getChildNodes();
             for(int contadorTags=0; contadorTags<datosItem.getLength(); contadorTags++) 
             {           
                 tag = datosItem.item(contadorTags); 
                 datoContenido = tag.getFirstChild();

                 if(tag.getNodeName().equals("contrasena") && datoContenido.getNodeValue().equals(""+contrasena))
                 {
                    itemEncontrado=true;     
                 }
                 if(itemEncontrado && contador<2)
                 {
                    arregloInformacion[contador]=datoContenido.getNodeValue();
                    contador++;
                 }
             }

         }
         return itemEncontrado;
    }
    public String[] getArregloInformacion()
    {
        return this.arregloInformacion;
    }
     //***Iniciar Sesion***////
   public String devolverTipo()
   {
       return tipo;
   }
  public boolean iniciarSesion(String arreglo[])
    { 
         Element raiz = document.getDocumentElement();
         NodeList listaDeItems = raiz.getElementsByTagName("Usuario");
         Node tag=null,datoContenido=null;

         boolean itemEncontrado=false,tituloNombre=false;
         int contador=0;

         for(int contadorItems=0; contadorItems<listaDeItems.getLength(); contadorItems++) 
         {   
             Node item = listaDeItems.item(contadorItems);
             NodeList datosItem = item.getChildNodes();
             for(int contadorTags=0; contadorTags<datosItem.getLength(); contadorTags++) 
             {           
                 tag = datosItem.item(contadorTags); 
                 datoContenido = tag.getFirstChild();


                 if(tag.getNodeName().equals("nombre") && tag.getNodeName().equals("contrasenna") )
                 {
                    itemEncontrado=true;    
                   
                 }
                 if(itemEncontrado && contador<2)
                 {
                    arregloInformacion[contador]=datoContenido.getNodeValue();
                    contador++;
                 }
             }

         }
         return itemEncontrado;
   }
  public boolean registrarLogin(String arreglo[])
  {
       Element raiz = document.getDocumentElement();
         NodeList listaDeItems = raiz.getElementsByTagName("Usuario");
         Node tag=null,datoContenido=null;

         boolean itemEncontrado=false,tituloNombre=false;
         int contador=0;

         for(int contadorItems=0; contadorItems<listaDeItems.getLength(); contadorItems++) 
         {   
             Node item = listaDeItems.item(contadorItems);
             NodeList datosItem = item.getChildNodes();
             for(int contadorTags=0; contadorTags<datosItem.getLength(); contadorTags++) 
             {           
                 tag = datosItem.item(contadorTags); 
                 datoContenido = tag.getFirstChild();


                 if(tag.getNodeName().equals("nombre") && datoContenido.getNodeValue().equals(""+arreglo[0]) && tag.getNodeName().equals("contrasena") && datoContenido.getNodeValue().equals(""+arreglo[1]))
                 {
                    itemEncontrado=true;    
                   
                 }
      
     
           }
         }
         return itemEncontrado;
  }
  public boolean consultarUsuarios()
  {
     return true; 
  }
         
}