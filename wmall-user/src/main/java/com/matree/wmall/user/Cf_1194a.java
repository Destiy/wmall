package com.matree.wmall.user;

import java.io.InputStream;
import java.util.Scanner;

public class Cf_1194a {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double T;
        T = in.nextInt();
        while (T-- > 0) {
            double n, x;
            n = in.nextInt();
            x = in.nextInt();
            System.out.println(String.format("%.0f", x * 2));
        }
    }
}
