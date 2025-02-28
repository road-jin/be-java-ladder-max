package kr.codesquad.view;

import java.util.Scanner;
import kr.codesquad.domain.LadderHeight;
import kr.codesquad.domain.Results;
import kr.codesquad.domain.Users;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static Users inputUserNames() {
        try {
            System.out.println("\n참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
            return new Users(SCANNER.nextLine());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return inputUserNames();
        }
    }

    public static LadderHeight inputLadderHeight() {
        try {
            System.out.println("\n최대 사다리 높이는 몇 개 인가요?");
            return new LadderHeight(Integer.parseInt(SCANNER.nextLine()));
        } catch (NumberFormatException e) {
            System.out.println("숫자가 아닌 값을 입력하였습니다.\n");
            return inputLadderHeight();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return inputLadderHeight();
        }
    }

    public static Results inputResults(int userCount) {
        try {
            System.out.println("\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
            return new Results(SCANNER.nextLine(), userCount);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return inputResults(userCount);
        }

    }

    public static String inputUserName() {
        System.out.println("\n결과를 보고 싶은 사람은?");
        return SCANNER.nextLine();
    }

    public static void close() {
        SCANNER.close();
    }
}
