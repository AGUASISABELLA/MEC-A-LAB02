package Ejercicio3;
import java.util.Arrays;
import java.util.Scanner;

public class EjerciciosPunto3 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String args[]) {
        
        
        int opcion = 0;
        
        do{
            System.out.println("");
            
            System.out.println("---Menu---"+
                "\n 1. Ejercicio 3.1"
                + "\n 2. Ejercicio 3.2"
                + "\n 3. Ejercicio 3.3"
                + "\n 4. Ejercicio 3.4"
                + "\n 5. Salir");
            System.out.println("Por favor digite la opción: ");
            opcion = sc.nextInt(); 
            
            switch (opcion) {
            case 1: 
                ejercicio1();
                break;
            case 2:
                ejercicio2();
                break;
            case 3:
                ejercicio3();
                break;
            case 4:
                ejercicio4();
                break;
               
        } 
        }while (opcion!=5);
 
        
        System.out.println("EL PROGRAMA HA FINALIZADO");
    }
    static void ejercicio1(){
        int cantidad_numeros;
        System.out.println("Seleccionaste el Ejercicio 3.1"+ "\n");
        System.out.println("Ingresa la cantidad de números a generar: ");
        cantidad_numeros = sc.nextInt();
        System.out.println("");
        int [] nums = new int[cantidad_numeros];
        int suma = 0;
        System.out.println("Los numeros generados son: ");
        for (int i =0; i < nums.length; i++){
            int aleatorio = (int) (Math.random()*100 + 1);
            
            nums[i]=aleatorio;
            
        }
        System.out.print(Arrays.toString(nums));
        System.out.println("\n");
        for (int i=0; i < nums.length; i++){
            suma += nums[i];
        }
        double media = suma / nums.length;
        System.out.println("La media es: "+ media);
        
        
        double mediana = 0;
        if (nums.length ==1){
            mediana = nums[0];   
        }else{
            if (nums.length % 2 == 0){
                mediana = (nums[(nums.length /2)-1]+ nums [(nums.length /2)])/2;
            }
            else{
                mediana = nums[nums.length/2];
            }
        }
        System.out.print("La mediana es: "+mediana);
        System.out.println("");
        
        
        int maximoNumRepeticiones= 0;
        double moda= 0;

        for(int i=0; i<nums.length; i++){
            int numRepeticiones= 0;
            
        for(int j=0; j<nums.length; j++){
            if(nums[i]==nums[j]){
                numRepeticiones++;
            }   
            if(numRepeticiones>maximoNumRepeticiones){
                moda= nums[i];
                maximoNumRepeticiones= numRepeticiones;
            }   
            }
            }   
        System.out.print("La moda es: "+moda);
        System.out.println("");
        
        double varianza = 0;
        for(int i = 0 ; i < nums.length; i++){
            double rango;
            rango = (Math.pow(nums[i] - media, 2f))/nums.length;
            varianza += rango;
        } 
        double desviacion = 0;
        
        desviacion = Math.sqrt(varianza);
        
        System.out.println("La varianza es: " + varianza);
        System.out.println("La desviacion estandar es: " + desviacion);
        System.out.println("");
        
    }
    
    static void ejercicio2(){
        System.out.println("Seleccionaste el Ejercicio 3.2"+ "\n");
            // Pedir al usuario que escriba una línea de caracteres
            System.out.println("Ingresa una línea de caracteres: ");
            String linea = sc.next();
            System.out.println("");
        
            // Imprimir la línea de caracteres en la consola
            System.out.println("La línea que escribiste es: " + linea);

            // Calcular la cantidad de veces que aparece cada vocal
            int[] vocales = new int[5];

            for (int i = 0; i < linea.length(); i++) {
                char c = linea.charAt(i);
                if (c == 'a' || c == 'A') {
                    vocales[0]++;
                } else if (c == 'e' || c == 'E') {
                    vocales[1]++;
                } else if (c == 'i' || c == 'I') {
                    vocales[2]++;
                } else if (c == 'o' || c == 'O') {
                    vocales[3]++;
                } else if (c == 'u' || c == 'U') {
                    vocales[4]++;
                }
            }

            // Encontrar la vocal que más se repite
            int maxRepeticiones = 0;
            char vocalMasRepetida = ' ';
            for (int i = 0; i < vocales.length; i++) {
                if (vocales[i] > maxRepeticiones) {
                    maxRepeticiones = vocales[i];
                    switch (i) {
                        case 0:
                            vocalMasRepetida = 'a';
                            break;
                        case 1:
                            vocalMasRepetida = 'e';
                            break;
                        case 2:
                            vocalMasRepetida = 'i';
                            break;
                        case 3:
                            vocalMasRepetida = 'o';
                            break;
                        case 4:
                            vocalMasRepetida = 'u';
                            break;
                    }
                }
            }

            // Reemplazar la vocal que más se repite por un guion
            String lineaModificada = linea.replace('a',vocalMasRepetida).replace('e',vocalMasRepetida)
                   .replace('i',vocalMasRepetida).replace('o',vocalMasRepetida).replace('u',vocalMasRepetida);

            // Imprimir la línea modificada en la consola
            System.out.println("La línea modificada es: " + lineaModificada);

            String cadenaInvertida = "";
            for (int x = linea.length() - 1; x >= 0; x--)
                cadenaInvertida = cadenaInvertida + linea.charAt(x);

            System.out.println("La línea invertida es: " + cadenaInvertida);  

    }

    public static void ejercicio3() {
        System.out.println("Seleccionaste el Ejercicio 3.2"+ "\n");
        
        int opcion = 0;
        
        do{
            System.out.println("");
            System.out.println("---Menu---"+
                "\n 1. Método burbuja"
                + "\n 2. Método inserción"
                + "\n 3. Método selección"
                + "\n 4. Método mergesort"
                + "\n 5. Salir");
            System.out.println("Por favor digite la opción: ");
            opcion = sc.nextInt(); 

        int[] sizes = {100, 500, 1000, 5000, 10000};
        for (int size : sizes) {
            int[] arr = new int[size];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (int) (Math.random() * 1000);
            }
            long startTime, endTime;
            if (opcion == 1){
                startTime = System.nanoTime();
                bubbleSort(arr.clone());
                endTime = System.nanoTime();
                System.out.printf("Método burbuja con %d números al azar, tiene un tiempo de: %.4f ms\n", size, (endTime - startTime) / 1000000.0);
                System.out.println("");
            }
            else{
                if (opcion == 2){
                    startTime = System.nanoTime();
                    insertionSort(arr.clone());
                    endTime = System.nanoTime();
                    System.out.printf("Método inserción con %d números al azar, tiene un tiempo de: %.4f ms\n", size, (endTime - startTime) / 1000000.0);
                    System.out.println("");
            }
                else{
                    if(opcion == 3){
                        startTime = System.nanoTime();
                        selectionSort(arr.clone());
                        endTime = System.nanoTime();
                        System.out.printf("Método selección con %d números al azar, tiene un tiempo de: %.4f ms\n", size, (endTime - startTime) / 1000000.0);
                        System.out.println("");
                    }
                    else{
                        if(opcion == 4){
                        startTime = System.nanoTime();
                        mergesort(arr.clone());
                        endTime = System.nanoTime();
                        System.out.printf("Método mergesort con %d números al azar, tiene un tiempo de: %.4f ms\n", size, (endTime - startTime) / 1000000.0);
                        System.out.println("");
                }
                
                
                        }
                        }
            
                
            }

        }
        }while (opcion!=5);
        System.out.println("EL PROGRAMA HA FINALIZADO");
    }
        

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    public static void mergesort(int[] arr) {
        if (arr.length > 1) {
            int mid = arr.length / 2;
            int[] left = Arrays.copyOfRange(arr, 0, mid);
            int[] right = Arrays.copyOfRange(arr, mid, arr.length);
            mergesort(left);
            mergesort(right);
                    int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < left.length) {
            arr[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }
}
    
    static void ejercicio4(){
        ventana b = new ventana();
        
    }

}