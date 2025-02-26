public class DogNeighbor {
    public static void main(String[] args) {
        Dog[] dogs = new Dog[20]{

        }//创建一个有11个dog的dogs数组
        dogs[0] = new Dog(10);
        dogs[1] = new Dog(15);
        dogs[2] = new Dog(20);
        dogs[3] = new Dog(15);
        dogs[4] = new Dog(10);
        dogs[5] = new Dog(5);
        dogs[6] = new Dog(10);
        dogs[7] = new Dog(15);
        dogs[8] = new Dog(22);
        dogs[9] = new Dog(15);
        dogs[10] = new Dog(20);
        Dog[] dogsbigger = new Dog[10];
        //找到所有dogs相邻四个邻居中最大的邻居，并将结果打印成数组模式
        boolean juagebigger = true;
        int bigger = 0;//记录最终的数组
        for(int i=0;i<dogs.length;i++)
        {
            for(int j=-2;j<=2;j++)
            {
                if(i+j > dogs.length)
                    break;
                if(i+j < 0)
                    continue;
                if(dogs[i].weight<dogs[j+i].weight)
                {
                    juagebigger = false;
                }
            }
            if(juagebigger == true)
            {
                dogsbigger[bigger++] = new Dog(dogs[i].weight);
            }else{
                juagebigger = true;
            }
        }
        for(int i=0;i<dogsbigger.length;i++)
        {
            System.out.println(dogsbigger[i].weight);
        }
    }
}