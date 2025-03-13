public class HoFDemo {
    public static void main(String[] args) {
        TenX tenx = new TenX();
        System.out.println(tenx.apply(tenx.apply(2)));
    }
}
