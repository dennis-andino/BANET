/* PROGRAMACION I SECCION 989 
ING. ALBERTO MONDRAGON

EST: DENNIS M. ANDINO
CUENTA:31711467

*/

package banet_proy1;
import javax.swing.JOptionPane;
public class Banet_proy1 {
    static String nombres[]=new String[10];
    static String apellidos[]=new String[10];
    static String correo[]=new String[10];
    static int cuenta[]=new int[10];
    static String pin[]=new String[10];
    static int telefono[]=new int[10];
    static double monto[]=new double[10];
    
    public static void main(String[] args) {
        //Inicializacion con un primer registro
       int menurespuesta=0;
       boolean encendido=true;
       nombres[0]="juana";
       apellidos[0]="Perez";
       correo[0]="juana_peres@outlook.com";
       cuenta[0]=11111;
       pin[0]="1000";
       telefono[0]=97234568;
       monto[0]=0;
       //MENU//
      while(encendido==true)
      {
          try{
       menurespuesta=Integer.parseInt(JOptionPane.showInputDialog(" BIENVENIDO A BANET \n ¿ Qué transaccion deseas Realizar ? \n \n"
               + "1-INGRESAR CLIENTE \n 2-RETIRAR CLIENTE \n 3-DEPOSITOS \n 4-RETIROS \n 5-ESTADO DE CUENTA \n 6-SALIR \n \n Ingresa el numero de la opcion elegida"));
       switch(menurespuesta)
       {
           case 1: ingresar_cliente();
             break;
           case 2: retirar_cliente();
             break;
           case 3: depositos();
             break;
           case 4: retiros();
             break;
           case 5: estado_de_cuenta();
             break;
           case 6:  
               encendido=false;
               break;
           default: JOptionPane.showMessageDialog(null, "Selecciona una opcion válida, por favor intentalo de nuevo :)");
       }
      }catch(Exception e){JOptionPane.showMessageDialog(null,"Selecciona una opcion válida, por favor intentalo de nuevo :)");}
      }
    }
    
    //INGRESO DE LOS REGISTROS 
    public static void ingresar_cliente()
    {
   boolean proceso=true;
   int numero_usuarios=0;
   int indiceu=0;
   int k=0;
    JOptionPane.showMessageDialog(null,"Bienvenido al Ingreso de Datos BANET  ");
   for (int j=0;j<cuenta.length;j++)
   {
    if (cuenta[j]==0)
    {
        k++;
    } 
   }
   while(true){
   try{
    numero_usuarios=Integer.parseInt(JOptionPane.showInputDialog("¿Cuantos usuarios Ingresara al sistema"));
    if (numero_usuarios<0)
    {
        numero_usuarios=numero_usuarios*-1;
    }
   break;}
   catch(Exception e){JOptionPane.showMessageDialog(null,"Ingresa solamente numeros");}
   }
   
    if(numero_usuarios>=k){
    JOptionPane.showMessageDialog(null,"No hay espacio suficiente en base de datos :( \n Solamente se ingresaran "+k+" registros "+"elimina "+(numero_usuarios-k)+ " Registros antiguos"  );
    numero_usuarios=k;
    }
    
    while (proceso==true)
    {
        if(cuenta[indiceu]==0){
     for (int i=0;i<numero_usuarios;i++)
     {
         if(cuenta[indiceu]==0){
        nombres[indiceu]=JOptionPane.showInputDialog(null, "Ingrese el nombre del Cliente: ");
        apellidos[indiceu]=JOptionPane.showInputDialog(null, "Ingrese el apellido del Cliente: ");
        correo[indiceu]=validar_correo();
        telefono[indiceu]=validar_telefono();
        pin[indiceu]=validar_pin();
        cuenta[indiceu]=cuenta[indiceu-1]+1;
        monto[indiceu]=validar_monto();
        JOptionPane.showMessageDialog(null,"Su numero de cuenta es : "+cuenta[indiceu]);
        indiceu++;
         }
         else
         {
             i--;
             indiceu++;
         }
     }
     JOptionPane.showMessageDialog(null,"se guardaron los registros satisfactoriamente");
     proceso=false;
        }
        else{
            indiceu++;   
            }
    }
    }
    // RETIRAR O ELIMINAR  CLIENTES 
    
    public static void retirar_cliente()
    {
        int cuenta_buscar;
        int i=0;
        while(true){
            try{
        cuenta_buscar=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de cuenta del cliente que desea eliminar"));
            break;}
            catch(Exception e){JOptionPane.showMessageDialog(null,"No se aceptan letras ni caracteres especiales");
            }
        }
        i=buscar_indice(cuenta_buscar);
        if (i!=-1)
            {
       nombres[i]=null;
       apellidos[i]=null;
       correo[i]=null;
       cuenta[i]=0;
       pin[i]=null;
       telefono[i]=0;
       monto[i]=0;
       JOptionPane.showMessageDialog(null, "Se eliminaron los registros satisfactoriamente");
       
            }
            else{
                JOptionPane.showMessageDialog(null, "Has ingresado un numero de cuenta que no existe,Intentalo nuevamente :)");
                
            }
        
    }
    
    //HACER DEPOSITOS 
    public static void depositos()
    {
       int ncuenta;
       int d;
       int deposito=0;
       while(true){
       try{
       ncuenta=Integer.parseInt(JOptionPane.showInputDialog("Por favor ,Ingrese el numero de cuenta del cliente"));
       break;
       }catch(Exception e){JOptionPane.showMessageDialog(null,"No se aceptan letras ni caracteres Especiales,solamente numeros ");
       }
       }
       
       if (ncuenta<11111){JOptionPane.showMessageDialog(null, "has ingresado un numero de cuenta Invalido");}
       else
       {
       d=buscar_indice(ncuenta); 
       if (d!=-1)
       {
           deposito=Integer.parseInt(JOptionPane.showInputDialog("Por favor ,Ingrese la cantidad a depositar en L. "));
           if(deposito>=0){
           monto[d]=monto[d]+deposito;}
           else
           {
               monto[d]=monto[d]+(deposito*-1);
           }
           JOptionPane.showMessageDialog(null, "se ha sumado satisfactoriamente el deposito, su nuevo saldo es : "+monto[d]);
       }
       else{JOptionPane.showMessageDialog(null, "El numero de cuenta digitado no existe, verificalo e intentalo nuevamente");}
       }
    }
    
    //BUSCAR INDICE 
    public static int buscar_indice(int cuentaus)
    {
        int indice=-1;
        for (int i=0; i<=9; i++)
            if (cuenta[i]==cuentaus)
                indice=i;
        return indice;
        
    }
    
    //RETIROS 
    public static void retiros()
    {
        int ncuentar;
       int e;
       int retiro=0;
       String pinn;
       while(true){
       try{
       ncuentar=Integer.parseInt(JOptionPane.showInputDialog("Por favor ,Ingrese el número de cuenta del cliente "));
       pinn=JOptionPane.showInputDialog("Por favor ,Ingrese el pin ");
       break;}
       catch(Exception h){JOptionPane.showMessageDialog(null, "Solamente ingrese numeros ");}
       }
       if (ncuentar<11111){JOptionPane.showMessageDialog(null, "has ingresado un numero de cuenta/pin  Invalido ");}
       else
       {
       e=buscar_indice(ncuentar); 
       if (e!=-1 && pinn.equals(pin[e]))
       {
           retiro=Integer.parseInt(JOptionPane.showInputDialog("Por favor ,Ingrese la cantidad a retirar en L. "));
           if (monto[e]<retiro || retiro<=0){JOptionPane.showMessageDialog(null,"El monto que desea retirar , es incorrecto/mayor al saldo de la cuenta \n su saldo es "+monto[e]);}
           else{
           monto[e]=monto[e]-retiro;
           JOptionPane.showMessageDialog(null, "se ha realizado satisfactoriamente su retiro, su nuevo saldo es : "+monto[e]);}
       }
       else{JOptionPane.showMessageDialog(null, "El numero de cuenta/pin  digitado no existe, verificalo e intentalo nuevamente");}
       }
    
    }
    //ESTADO DE CUENTA 
    public static void estado_de_cuenta()
    {
        int numcuenta;
        int x;
        double totalm=0;
        int menus;
        while (true)
        {
            try{
       menus=Integer.parseInt(JOptionPane.showInputDialog("Que estado de cuenta desea realizar: \n 1. General \n 2. Por cliente \n 3. Regresar"));
            
       if (menus==3){
           break;
       }
       switch (menus)
               {
           case 1:
                   {
                       String messagem="";
                       for(int z=0;z<cuenta.length;z++)
                       {
                       totalm=totalm+monto[z];
          messagem=messagem+" Nombre:  "+nombres[z]+" "+apellidos[z]+"  Telefono:  "+telefono[z]+"  N° cuenta:  "+cuenta[z]+"  Monto : L.  "+monto[z]+"\n";
                       }
                        JOptionPane.showMessageDialog(null,"ESTADO DE CUENTA BANET\n"+messagem+ "Total Neto : "+totalm);
                       break;
                    }
           case  2 :
                   {
      numcuenta=Integer.parseInt(JOptionPane.showInputDialog("Ingresa el numero de cuenta del usuario:  "));
      x=buscar_indice(numcuenta);
      if (x!=-1){
      JOptionPane.showMessageDialog(null, "Nombre : "+nombres[x]+" "+apellidos[x]+"\n N° de cuenta : "+cuenta[x]+"\n Saldo:  "+monto[x]);}
      else {JOptionPane.showMessageDialog(null, "has ingresado mal el numero de cuenta, vuelve a intentarlo");}
                   break;
                   } 
           default: JOptionPane.showMessageDialog(null,"escribe 1 para para un estado de cuenta de todo el sistema o 2 para el estado de cuenta de solo un usuario");
       }
    }
            
catch(Exception e){JOptionPane.showMessageDialog(null,"El valor ingresado no corresponde a ninguna opción válida, intentalo nuevamente");
}
        }
    }         
  //VALIDAR CORREO
    public static String validar_correo()
    {
        String correu="";
        boolean procorreo=true;
        while(procorreo==true)
       {
        correu=JOptionPane.showInputDialog("Ingrese el correo del cliente :");
        if (correu.indexOf("@")==-1)
        {
             JOptionPane.showMessageDialog(null, "por favor ,ingresa un correo valido");
        }
        else
        {
        procorreo=false;
        }
       }
        return correu;
    }    
    
   //VALIDAR PIN
    public static String validar_pin()
    {
       String pinp="";
        int pin2=0;
        boolean validacion=true;
      while (validacion==true)
        {
       pinp=JOptionPane.showInputDialog("Ingrese el valor del pin : ");
       if (pinp.length()!=4)
       {
           JOptionPane.showMessageDialog(null,"Ingresa un digito de 4 cifras");
       }
       else
       {
           try{
           pin2=Integer.parseInt(pinp);
           validacion=false;}
           catch(Exception e){JOptionPane.showMessageDialog(null,"No se aceptan letras , solamente numeros"); }  
       } 
     }
       
           if(pin2>0 && pin2<10)
           {
              pinp=String.valueOf("000"+pin2);
              return pinp;
           }
           else if (pin2>0&&pin2<100)
           {
               pinp=String.valueOf("00"+pin2);
              return pinp;
           }
           else if (pin2>0&&pin2<1000)
           {
               pinp=String.valueOf("0"+pin2);
              return pinp;
           }
           else
           {
             return pinp;  
           }
    }
    //VALIDAR TELEFONO
    public static int validar_telefono(){
    int tel=0;
    while(true){
     try{   
     tel=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el telefono del Usuario"));}
     catch(Exception e){JOptionPane.showMessageDialog(null, "No se aceptan letras ni caracteres especiales :) ");
     continue;}
     if (tel<10000000){
     JOptionPane.showMessageDialog(null, "Ingresa un numero de telefono valido (no se aceptan letras ni caracteres especiales))");
     continue;}
     else
     {
       break;
    } 
    }
    return tel;
    }
    //VALIDAR MONTO
    public static double validar_monto()
    {
    double quantidade=0;
        while(true){
     try{   
     quantidade=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el monto con el que se aperturara la cuenta L."));}
     catch(Exception e){JOptionPane.showMessageDialog(null, "No se aceptan letras ni caracteres especiales :) ");
     continue;}
     if (quantidade<0){
     JOptionPane.showMessageDialog(null, "La cantidad ingresada es valida , Ingrese solo numeros positivos");
     continue;}
     else
     {
       break;
    } 
    }
        return quantidade;    
    }
    
    private static void ordenar_cuentas()
    {
      String aux_nombre,aux_apellido,aux_correo,aux_pin;
      int aux_cuenta,aux_telefono;
      double aux_monto;
      boolean cambio;
      while(true){
         cambio=false;
         for (int i=1;i<monto.length;i++){
             if(monto[i]<monto[i-1]){
                 aux_monto=monto[i];
                 aux_nombre=nombres[i];
                 aux_apellido=apellidos[i];
                 aux_correo=correo[i];
                 aux_cuenta=cuenta[i];
                 aux_pin=pin[i];
                 aux_telefono=telefono[i];
               monto[i]=monto[i-1];
               apellidos[i]=apellidos[i-1];
               correo[i]=correo[i-1];
               cuenta[i]=cuenta[i-1];
               nombres[i]=nombres[i-1];
               pin[i]=pin[i-1];
               telefono[i]=telefono[i-1];
               
                 
             }
         }
      }
    }
}
          
    


   
