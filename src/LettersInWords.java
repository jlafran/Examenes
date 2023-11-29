import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LettersInWords {

//    Given 2 arrays, one of letters and one of words, find all words that can be written with the letters
//    Example:

//    words = ["tarta", "arroz", "rota"]
//    letters = ["a", "t", "r", "o", "r", "z", "c", "a", "a", "a"]

//    Expected Result: ["arroz", "rota"]
    public static HashMap<String,Integer> arrayToHashmap (String[] letters){
        HashMap<String,Integer> lettersMap = new HashMap<>();
        for(String letter : letters ){
            if (lettersMap.containsKey(letter)){
                lettersMap.put(letter,lettersMap.get(letter) + 1);
            } else {
                lettersMap.put(letter, 0);
            }
        }
        return lettersMap;
    }
    public static List<String> palabrasDeLetras (String[] words,HashMap<String,Integer> letters){
        List<String> palabras = new ArrayList<>();
        for (String word : words){
            String palabra = "";
            String[] letras = word.split("");
            HashMap<String,Integer> duplicado = (HashMap<String, Integer>) letters.clone();
//            char[] letras = word.toCharArray();
            for (String letra : letras){
                if(duplicado.containsKey(letra) && !duplicado.get(letra).equals(-1)){
                    palabra = palabra + letra;
                    duplicado.put(letra, letters.get(letra) - 1);
                }
            }
            if (word.equals(palabra)){
                palabras.add(palabra);
            }
        }
        return palabras;
    }
    public static List<String> palabrasDeLetrasDos (String[] words,HashMap<String,Integer> letters){
        List<String> palabras = new ArrayList<>();
        for (String word : words){
            String palabra = "";
            String[] letras = word.split("");
            HashMap<String,Integer> letrasPalabra = arrayToHashmap(letras);
//            char[] letras = word.toCharArray();
            for (String letra : letras){
                if(letters.containsKey(letra) && letters.get(letra) >= letrasPalabra.get(letra)){
                    palabra = palabra + letra;
                }
            }
            if (word.equals(palabra)){
                palabras.add(palabra);
            }
        }
        return palabras;
    }

    public static void Imprimir(List imprimir){
        for (Object imp : imprimir){
            System.out.println(imp);
        }
    }

    public static void main(String[] args) {
        String[] words = {"tarta", "arroz", "rota"};
        String[] letters = {"a", "t", "r", "o", "r", "z", "c", "a", "a", "a"};
        Imprimir(palabrasDeLetrasDos(words,arrayToHashmap(letters)));
    }
}
