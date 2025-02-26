public class DogLauncher
{
    public static void main(String[] args)
    {
        int dogsname = 2;
        if(dogsname == 1)
        {
            MalamuteDog.makenoise();
        } else
        {
            TinyDog.makenoise();
        }
    }
}