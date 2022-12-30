

// İkram Celal Keskin


import java.util.Scanner;
public class project1
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner( System.in );
        int m,n,temp; //m order of a tree
        System.out.print("Enter the m (order of tree) of the Tree?  ");
        m=input.nextInt();

        while ( m<2)
        {
            System.out.print("Enter a integer greater than 1 : ");
            m=input.nextInt();                      //   order of Tree and is assinged to m.
        }
        BTree tree = new BTree(m);//  B-Tree Tree with order N is created.

        System.out.print("\n How many values do you want to enter?:  ");
        n = input.nextInt();

        for ( int i=0;i< n;i++)
        {
            System.out.print("\nEnter Value:");
            System.out.println(i+1);
            temp=input.nextInt();
            tree.insert(tree,temp);
        }
        int choice;
        boolean running;
        running=true;
        System.out.println("1. Enter more values in a Tree");
        System.out.println("2. Print the whole  Tree in preorder");
        System.out.println("3. Exit");

        while (running)// This While loop runs as long as the user enters anything other than a 3.
        {
            System.out.print("\nPlease enter your choice::");
            choice=input.nextInt();
            if ( choice == 3)
            {
                System.out.printf("The program is exiting...,");
                System.exit(0);
                running=false;
                break;
            }
            else
            {
                switch(choice)
                {
                    case 1:      // function to Enter more values in a Tree.
                        System.out.print("How many values do you want to enter?:");
                        n=input.nextInt();

                        for ( int i=0;i< n;i++)
                        {
                            System.out.print("\nEnter Value: ");
                            System.out.println(i+1);
                            temp=input.nextInt();
                            tree.insert(tree,temp);
                        }
                        break;

                    case 2:// function to Print the Tree in preorder.
                        tree.print(tree.root);
                        System.out.println();
                        break;
                    case 3:
                        System.exit(0); //its function is to Exit
                        break;

                    default:
                        System.out.println("\nPlease enter a valid choice of 1,2,3\n");
                        break;
                }
            }
        }
    }
}