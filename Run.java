package Exc_20;

public class Run
{
    public static void main(String[] args)
    {
        LinkedIntList list = new LinkedIntList();
        list.add(3);
        list.add(7);
        list.add(12);
        list.add(13);
        list.add(15);
        list.add(18);
        list.add(1);
        list.add(5);
        System.out.println(list);
        list.shift();
        System.out.println(list);
    }
}
