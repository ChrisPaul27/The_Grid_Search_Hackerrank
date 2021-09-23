package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        String out = "";
        Scanner in = new Scanner(new File("input/input07.txt"));
        int nRepeat = Integer.parseInt(in.nextLine()), n, i;
        for (n = 0; n < nRepeat; n++) {
            int R = Integer.parseInt(in.nextLine().split(" ")[0]);
            List <String> G = new ArrayList<>();
            for (i = 0; i < R; i++) {
                G.add(in.nextLine());
            }
            List <String> P = new ArrayList<>();
            int r = Integer.parseInt(in.nextLine().split(" ")[0]);
            for (i = 0; i < r; i++) {
                P.add(in.nextLine());
            }
            out = out + new Main().run(G, P) + "\n";
        }
        System.out.print(out);
    }

    public String run(List <String> G, List<String> P) {
        String out = "NO";
        int i, j, tmp = 0;
        for (i = 0; i < G.size() - P.size() + 1; i++) {

            for (j = 0; j < G.get(i).length() - P.get(0).length() + 1; j++) {
                tmp = check(G, P, i, j);
                /*indexOf restituisce solo la prima occorrenza, quindi ripeto la funzione check, cercando
                la prima stringa di P più volte in una stringa di G spostando l'indice da cui effettuare la ricerca
                 */
                if (tmp == P.size()) {
                    break;
                }
            }

            if (tmp == P.size()) {
                out = "YES";
                break;
            }
        }
        return out;
    }

    public int check(List <String> G, List <String> P, int i, int start) {
        int tmp = 0, k , j;
        int startIndex = G.get(i).indexOf(P.get(0), start);
        if (startIndex != -1) {
            k=i+1;
            tmp++;
            for (j = 1; j < P.size(); j++) {
                if (G.get(k).startsWith(P.get(j), startIndex)) {
                    tmp++;
                    k++;
                } else {
                    break;
                }
            }
        }
        return tmp;
    }
}
