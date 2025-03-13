public class StringCompare implements OurComparable{
    String str;
    int length;
    public StringCompare(String str, int length)
    {
        this.str = str;
        this.length = length;
    }
    @Override
    public int compareTo(OurComparable o) {
        StringCompare string = (StringCompare) o;
        return this.length-string.length;
    }
    public static void main(String[] args) {
        StringCompare[] strings = {
                new StringCompare("hello",5),
                new StringCompare("hybaba",6),
                new StringCompare("success",7),
        };
        System.out.println(((StringCompare)Maximizer.Max(strings)).length);
    }
}
