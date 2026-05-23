package View;

import Model.Entity.Media;

import java.util.List;
import java.util.Scanner;

public class MediaView {
    private static final Scanner sc = new Scanner(System.in);

    public String getInput(){
        return sc.nextLine().trim();
    }

    public void printMainMenu(int activeCount){
        String status = activeCount > 0 ? "재생 중 : "+activeCount + "개" : "실행 중인 파일이 없습니다.";
        System.out.println("             메인 메뉴              ");
        System.out.println(status);
        System.out.println("************************************");
        System.out.println("     1. 음성 찾기   2. 영상 찾기      ");
        System.out.println("     3. 전체 목록   4. 재생 현황      ");
        System.out.println("     0. 종료            ");
        System.out.println("************************************");
        System.out.println("원하시는 메뉴를 입력해주세요 >> ");
    }
    public void printAudioMenu() {
        System.out.println("음성 찾기");
        System.out.println("1. 음원 찾기");
        System.out.println("0. 메인메뉴로 돌아가기");
        System.out.println("************************************");

        System.out.print("선택 >> ");
    }
    public void printVideoMenu() {
        System.out.println("영상 찾기");
        System.out.println("1. 영화       2. 드라마");
        System.out.println("0. 메인메뉴로 돌아가기");
        System.out.println("************************************");

        System.out.print("선택 >> ");
    }
    public void printMediaList(String title, List<? extends Media> list) {
        System.out.println("\n----- " + title + " -----");
        for (int i = 0; i < list.size(); i++) {
            Media m = list.get(i);
            System.out.printf("  %d. %-25s (재생 횟수: %d)%n",
                    i + 1, m.getTitle(), m.getPlayCnt());
        }
        System.out.println("  0. 돌아가기");
        System.out.print("재생할 번호 >> ");
    }

    public void printStatus(List<Media> allMedia) {
        System.out.println("\n========== 최종 재생 횟수 ==========");
        for (Media m : allMedia) {
            System.out.printf("  %-25s : %d회%n", m.getTitle(), m.getPlayCnt());
        }
        System.out.println("====================================");
    }

    public void printMessage(String msg) {
        System.out.println(msg);
    }
}
