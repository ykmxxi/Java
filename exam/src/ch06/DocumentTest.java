package ch06;

// 멤버변수 초기화 시기와 순서 확인을 위한 예제

/*

    1. 제목이 없을 때 제목없음1 부터 차례대로 생성된다.
    2. 문서의 파일형식은 .txt 파일로 통일

 */
class Document {

    static int count = 0;
    String documentName;


    Document() {
        this("제목없음" + ++count + ".txt");
    }

    Document(String documentName) {
        this.documentName = documentName;
        System.out.println("문서 " + this.documentName + " 가 생성되었습니다.");
    }
}

class DocumentTest {

    public static void main(String[] args) {

        Document document1 = new Document();
        Document document2 = new Document("java.txt");
        Document document3 = new Document();
        Document document4 = new Document();

    }
}
