package test.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main ( String[] args ) throws IOException {
        var leftBracketsStack = new Stack<Integer> ( );
        char[] output;

        try (var reader = new BufferedReader ( new InputStreamReader ( System.in ) )) {
            var input = reader.readLine ( );
            output = input.toCharArray ( );
            var brackets = input.toCharArray ( );

            for (var i = 0; i < brackets.length; i++) {
                var character = brackets[ i ];
                if ( character == '(' ) {
                    leftBracketsStack.add ( i );
                } else if ( character == ')' ) {
                    if ( !leftBracketsStack.empty ( ) ) {
                        leftBracketsStack.pop ( );
                    } else {
                        output[ i ] = '_';
                    }

                }
            }
        }

        for (var unclosedLeftBracketIndex : leftBracketsStack) {
            output[ unclosedLeftBracketIndex ] = '_';
        }

        var result = new String ( output ).replaceAll ( "[^\\(\\)]", "" );//replace all not bracket symbols

        System.out.println ( result.length ( ) + "-" + result );
    }
}
