package ch07.modifier;

class Time {
    private int hour;
    private int minute;
    private int second;

    Time(int hour, int minute, int second) {
        setHour(hour);
        setMinute(minute);
        setSecond(second);
    }


    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        if (hour < 0 || hour > 23) {
            return;
        }

        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        if (minute < 0 || minute > 59) {
            return;
        }

        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        if (second < 0 || second > 59) {
            return;
        }

        this.second = second;
    }

    @Override
    public String toString() {
        return hour + ":" + minute + ":" + second;
    }
}


public class AccessModifierTimeTest {

    public static void main(String[] args) {

        Time time = new Time(12, 35, 10);
        System.out.println(time);

        // time.hour = 11; -> hour has private access
        time.setHour(time.getHour() + 1);
        System.out.println(time);   // 멤버변수로의 적접적인 접근은 허가되지 않고, 메서드를 통한 접근만이 허용 된다.

    }

}
