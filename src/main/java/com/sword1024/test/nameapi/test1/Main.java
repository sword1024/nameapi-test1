package com.sword1024.test.nameapi.test1;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.math.BigDecimal;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static final Pattern LINE = Pattern.compile("^(?<command>\\w+)(?:\\s+(?<number>-?\\d+(?:\\.\\d+)?))?");

    public static void main(String[] args) throws IOException {
        NumbersService numbersService = new NumbersServiceImpl();

        Consumer<BigDecimal> printNumber = number -> System.out.print(number != null ? number : "not ready yet");
        try (LineNumberReader in = new LineNumberReader(new InputStreamReader(System.in))) {
            for (; ; ) {
                System.out.print("\n input one of: 'offer <number>', 'min', 'max', 'avg', 'quit' > ");
                String line = in.readLine();
                Matcher matcher = LINE.matcher(line);
                if (matcher.matches()) {
                    String command = matcher.group("command");
                    switch (command) {
                        case "offer":
                            String number = matcher.group("number");
                            if (number == null) {
                                System.out.print("wrong number");
                            } else {
                                numbersService.offer(new BigDecimal(number));
                            }
                            continue;
                        case "min":
                            printNumber.accept(numbersService.getMin());
                            continue;
                        case "max":
                            printNumber.accept(numbersService.getMax());
                            continue;
                        case "avg":
                            printNumber.accept(numbersService.getAvg());
                            continue;
                        case "quit":
                            return;
                    }
                }
                System.out.print("wrong command");
            }
        }
    }
}
