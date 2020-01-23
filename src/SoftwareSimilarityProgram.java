import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SoftwareSimilarityProgram {

    public static void main(String[] args) throws Exception {

        ReadCodeLine();

        ReadCodeCharacter();

    }

    public static void ReadCodeLine() throws FileNotFoundException {
        Scanner sc;

        System.out.print("Enter your username: ");
        sc = new Scanner(System.in);
        String name = sc.nextLine();

        System.out.print("\nEnter Program #1 File Name: ");
        sc = new Scanner(System.in);
        String file1 = sc.nextLine();

        System.out.print("\nEnter Program #2 File Name: ");
        sc = new Scanner(System.in);
        String file2 = sc.nextLine();


        StringBuilder prog1String = new StringBuilder();
        StringBuilder prog2String = new StringBuilder();

//        PAIR 1
//        System.out.print("\nPAIR 1\n\n");
        File prog1File = new File("C:\\Users\\User\\IdeaProjects\\Module 0\\src\\" + file1);
        File prog2File = new File("C:\\Users\\User\\IdeaProjects\\Module 0\\src\\" + file2);

//        PAIR 2
//        System.out.print("PAIR 2\n\n");
//        File prog1File = new File("C:\\Users\\User\\IdeaProjects\\Module 0\\src\\prog1.cpp.txt");
//        File prog2File = new File("C:\\Users\\User\\IdeaProjects\\Module 0\\src\\prog2.cpp.txt");

        Scanner prog1Scan = new Scanner(prog1File);
        Scanner prog2Scan = new Scanner(prog2File);

        String longestSamedtString = "";
        float sameLines = 0,totalLines = 0,lineLength = 0;

        while(prog1Scan.hasNextLine() || prog2Scan.hasNextLine()){
            String prog1Word = prog1Scan.nextLine();
            String prog2Word = prog2Scan.nextLine();

            prog1String.append(prog1Word + "\n");
            prog2String.append(prog2Word + "\n");

            if(prog1Word.equals(prog2Word)){
                int newLineLength = prog1Word.length();

                if(newLineLength > lineLength){
                    longestSamedtString = prog1Word;
                    lineLength = newLineLength;
                }

                sameLines++;
            }

            totalLines++;
        }

        float percentage = (sameLines / totalLines) * 100;

        System.out.println("\nLongest Similar String: \n" + longestSamedtString);

        System.out.println("\nSimilarity Percentage when Checked per Line: " + percentage + "%");

    }

    public static void ReadCodeCharacter() {

        int countChar=0;
        int countTotal=0;
        float percentage;
        try {
            File program1 = new File("C:\\Users\\User\\IdeaProjects\\Module 0\\src\\prog1.java");
            File program2 = new File("C:\\Users\\User\\IdeaProjects\\Module 0\\src\\prog2.java");
            Scanner myProg1 = new Scanner(program1);
            Scanner myProg2 = new Scanner(program2);
            while (true) {
                if(myProg1.hasNext() && myProg2.hasNext())
                {
                    String data1 = myProg1.nextLine();
                    String data2 = myProg2.nextLine();
                    int i=0;
                    while(true)
                    {
                        if(i<data1.length() && i<data2.length()){
                            if(data1.charAt(i)==data2.charAt(i))
                            {
                                countChar++;
                                countTotal++;
                            }
                            i++;
                        }
                        else if(i<data2.length())
                        {
                            countTotal++;
                            i++;
                        }
                        else if(i<data1.length())
                        {
                            countTotal++;
                            i++;
                        }
                        else
                        {
                            break;
                        }
                    }

                }
                else if(myProg1.hasNext())
                {
                    countTotal=countTotal+myProg1.nextLine().length();
                }
                else if(myProg2.hasNext())
                {
                    countTotal=countTotal+myProg2.nextLine().length();
                }
                else{
                    break;
                }

            }
            myProg1.close();
            myProg2.close();
            percentage=(float)countChar/(float) countTotal;
            System.out.println("\nSimilarity Percentage when Checked per Character: " + percentage*100+"%");
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


}
