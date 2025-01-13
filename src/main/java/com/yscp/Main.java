package com.yscp;

import com.yscp.domain.CalculatorGame;
import com.yscp.domain.Number;
import com.yscp.domain.strategy.BasicStrategy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CalculatorGame calculatorGame = new CalculatorGame(new BasicStrategy());
        Scanner scanner = new Scanner(System.in);

        String input;

        do {
            System.out.println("계산식을 입력해주세요 q 또는 Q 를 입력하면 종료됩니다.");
            input = scanner.nextLine();
            if (input == null || input.isBlank()) {
                break;
            }

            if (input.contains("Q") || input.contains("q")) {
                break;
            }

            try {
                Number result = calculatorGame.calculate(input);
                System.out.println("result :: " + result.value());
            } catch (Exception e) {
                scanner.close();
            }

        } while (true);

        scanner.close();
    }
}
