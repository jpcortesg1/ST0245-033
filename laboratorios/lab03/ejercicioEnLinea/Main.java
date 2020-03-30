import java.util.LinkedList;

public class Main {

    public static void main (String [] args) {
        String texto = "This_is_a_[Beiju]_text\n" +
                "[[]][][]Happy_Birthday_to_Tsinghua_University\n" +
                "asd[fgh[jkl\n" +
                "asd[fgh[jkl[\n" +
                "[[a[[d[f[[g[g[h[h[dgd[fgsfa[f\n" +
                "asd[gfh[[dfh]hgh]fdfhd[dfg[d]g[d]dg";

        String [] gua = texto.split("\n");
        for (int i = 0; i < gua.length; i++) {
            LinkedList<String> lista = organize(gua[i] + "]");
            for (int j = 0; j < lista.size(); j++) {
                System.out.print(lista.get(j));
            }
            System.out.println();
        }

    }

    public static LinkedList <String> organize (String texto) {
        LinkedList<String> lista = new LinkedList<>();
        String palabra = "";
        boolean inicio = true;
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) == '[') {
                if (inicio) lista.addFirst(palabra);
                if (!inicio) lista.addLast(palabra);
                inicio = true;
                palabra = "";
            } else if (texto.charAt(i) == ']') {
                if (inicio) lista.addFirst(palabra);
                if (!inicio) lista.addLast(palabra);
                inicio = false;
                palabra = "";
            } else {
                palabra = palabra + texto.charAt(i);
            }
        }
        return lista;
    }

}
