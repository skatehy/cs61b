public class DogProblem {
    //return the array of bigger dogs

    public static Dog[] largerThanFourNeighbors(Dog[] dogs)
    {
        boolean isdogsbigger = true;
        Dog[] returndogs = new Dog[dogs.length];
        int count = 0;//count the returndogs
        //for every dogs int the dogs array
        for(int i = 0;i < dogs.length;i++)
        {
            //compare it with around four dogs
            for(int j = -2;j <= 2;j++)
            {
                if(i+j >= dogs.length)
                    break;
                if(i+j < 0)
                    continue;
                if(dogs[i+j].weight > dogs[i].weight)
                    isdogsbigger = false;
            }

            if(isdogsbigger == true)
            {
                returndogs[count++] = dogs[i];
            }
            isdogsbigger = true;
        }
        returndogs =  returntruedogs(returndogs,count);
        return returndogs;
    }

    public static Dog[] returntruedogs(Dog[] returndogs,int count) {
        Dog[] returntruedogs = new Dog[count];
        for (int k = 0; k < count; k++) {
             returntruedogs[k] = returndogs[k];
        }
        return returntruedogs;
    }
    public static void main(String[] args) {
        Dog[] dogs = new Dog[]{//创建一个有11个dog的dogs数组new Dog(10);new Dog(15),
                new Dog(10),
                new Dog(20),
                new Dog(15),
                new Dog(10),
                new Dog(10),
                new Dog(5),
                new Dog(15),
                new Dog(22),
                new Dog(15),
                new Dog(20),
        };
        Dog[] bigDogs1 = largerThanFourNeighbors(dogs);
        for (int k = 0; k < bigDogs1.length; k += 1) {
            System.out.print(bigDogs1[k].weight + " ");
        }

    }
}