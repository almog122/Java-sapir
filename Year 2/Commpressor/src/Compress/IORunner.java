package Compress;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class IORunner {
    static String IN_FILE_PATH = "C:\\Users\\Almog Fadida\\Desktop\\CompressEx\\Romeo and Juliet  Entire Play.txt";

    static String OUT_FILE_PATH = "C:\\Users\\Almog Fadida\\Desktop\\CompressEx\\out\\out.txt";
    	
    static String IN_FILE_PATH2 = "C:\\Users\\Almog Fadida\\Desktop\\CompressEx\\out\\outComp.txt";
    
    public static void main(String[] args)
    {
    	
    	
        FileInputStream input;
        Compress compress = new Compress();
        FileOutputStream output;
        try
        {
            input = new FileInputStream(IN_FILE_PATH);
            output = new FileOutputStream(OUT_FILE_PATH);

            String[] strIn = new String[1];
            String[] strOut = new String[]{""};
            
            
            while (true)					// Keep going until forced out.
            {
                int x = input.read();
              
                strIn[0] += (char) x;
                
                if (x != -1) // -1 is EOF
                {
                    //	System.out.print(x);
                    //	System.out.print((char)x);
                    output.write(x);
                }
                else
                {
                    System.out.println(x);
                    break;

                }
            }


            input.close();
            output.close();

            compress.Compress(strIn,strOut);
            
            
            
            FileInputStream OutDe = new FileInputStream(IN_FILE_PATH2);
            
            while (true)					// Keep going until forced out.
                {
                    byte x = (byte) OutDe.read();
                    
                    if (x != -1) // -1 is EOF
                    {
                    	strOut[0] += (char) x;
                    }
                    else
                    {
                        System.out.println(x);
                        break;

                    }
                }
            
            //compress.Decompress(strOut, strIn);
            
            input.close();
            output.close();
            
        }
        
        catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


}
