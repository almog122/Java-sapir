package Compress;

import Base.Compressor;
import org.w3c.dom.Node;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

//Almog fadida 315544437
//Ariel simantov 207366865

public class Compress implements Compressor {

    static String OUT_FILE_PATH = "C:\\Users\\Almog Fadida\\Desktop\\CompressEx\\out\\outComp.txt";
    
    static String OUT_FILE_PATH2 = "C:\\Users\\Almog Fadida\\Desktop\\CompressEx\\out\\outCompDE.txt";
    
    final int AsciiChar = 256;
    
    @Override
    public void Compress(String[] input_names, String[] output_names) {
       
    	int[] frequency = new int[AsciiChar]; //Create a Ascii array for every character 
    									//Because every character represented in Ascii
       
    	String[] HuffCode = new String[AsciiChar]; // The value of every character according to the tree
        
    	FileOutputStream output;

        for(int i = 0; i < input_names[0].length() - 1; i++){ // not including the '\0'
            frequency[input_names[0].charAt(i)]++; //Adding the amount of time a character appear in the file
        }											//In her representative index

        NodeTree Root = new NodeTree(null ,null, 0 ,'\0'); 
      
        Root = Root.createTree(frequency); // Creating a huffman tree to make the character into bits

        String Str = "";
        String strHuffCode = "";
       
        HuffCode = MakeHuffCode(HuffCode,Root,Str); //Creating the huffman code so every character represented in her bit according to the tree

        for(int i = 0; i < input_names[0].length() - 1; i++) { // not including the '\0'
            output_names[0] += HuffCode[input_names[0].charAt(i)]; //Now we change the File character to the huffman code with the HuffCode
        }														//So now we get for example instead of a 'a' an 0111$
        
        for(int i = 0; i < HuffCode.length; i++){
        	if(HuffCode[i] != null)
            	strHuffCode += HuffCode[i]; //So it will be easier to make it a set of 8 bits i change the String[] to String 
        }

        
        byte[] byteHuffCode = new byte[((input_names[0].length() - 1) / 8) + strHuffCode.length()]; //Creating the amount of 8 sets of bits that we need
        																				//strHuffCode.length() is 256 so it divided by 8 
      																			//input_names[0].length() - 1 we don't know the amount so i divided it by 8
        
        for(int i = 0; i < (strHuffCode.length()); i++) { //Here we enter the codeHuff into the File
            
        	for(int j = 0; j < 8; j++) { //Set of 8 bits
        		byteHuffCode[i] += strHuffCode.charAt(j);
                
                
            }
            
          strHuffCode = strHuffCode.substring(8); //we used this part so we cut it
          
        } //Now at the start of the compressed File there is a decoding segment
        
        
        for(int i = (strHuffCode.length()); i < ((input_names[0].length() - 1) / 8) + (strHuffCode.length()) ; i++) { //Here we enter the encoded File we got
            
    			for(int j = 0; j < 8; j++) { // Set of 8 bits
    				byteHuffCode[i] += output_names[0].charAt(j);
        		}
        	
            	output_names[0] = output_names[0].substring(8);//we used this part so we cut it
        	
        }
        
      

        try
        {
            output = new FileOutputStream(OUT_FILE_PATH);

            for(int i = 0; i < byteHuffCode.length; i ++) //Create a new File with the 8 set Byte we created
            	output.write(byteHuffCode[i]);
            
            output.close();

        }
        
        catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void Decompress(String[] input_names, String[] output_names) {
    	
    	 FileOutputStream output;
    	
    	
    	String[] DeHuffCode = new String[AsciiChar]; //We need to extract the huff code we insert in the compressed File 
    											//256 Because that the amount of character in Ascii
    	int count = 0;
    	
    	byte end = '$'; //The end of an bits is '$' because how we create it in MakeHuffCode function
    	
		for(int i = 0; i < DeHuffCode.length; i++) {
			while(input_names[0].charAt(count) != end) { //until we reach the character '$'
				
				DeHuffCode[i] += input_names[0].charAt(count); //enter 1 or 0 to the index of the character so we can know what is her huffman code bits is to decode
				count++; // will go until the end of the decoding segment we entered at the Compress File
				
			}
		}
		
		input_names[0] = input_names[0].substring(count); //Cut the part of the decoding segment as we got it in DeHuffCode
		
		count = 0;
		
		String Check = "";
		
		 for(int i = 0; i < input_names[0].length() - 1; i++) { //Now we in the original compress File segment
			 
			 Check = "";
			 
			 while(input_names[0].charAt(count) != end) { //we get every character represented in our bits of Huffman code
				 
				 Check += input_names[0].charAt(count); //Create the character bits
				
				 count++; //Will go until the end of the File we got
				
			 }
			 
			 if(Check != null && !Check.isEmpty()) { 
			 	
				 for(int j = 0; j < DeHuffCode.length; j++) { //Using the decoding segment we got
			 		
					 if(DeHuffCode[j].compareTo(Check) > 0) { //Check which of the character It is with out decoding segment
					 
						 output_names[0] += (char) j; //Enter the character to the File
			 		}
			 		
			 	}
			 }
	     }
		 
		 
		  try
	        {
	            output = new FileOutputStream(OUT_FILE_PATH2);

	            for(int i = 0; i < output_names[0].length() - 1; i ++)
	            	output.write(output_names[0].charAt(i)); //Create the decoded File

	            output.close();

	        }
	        catch (Exception e)
	        {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
		
    	
    }

    @Override
    public byte[] CompressWithArray(String[] input_names, String[] output_names) {
        return null;
    }

    @Override
    public byte[] DecompressWithArray(String[] input_names, String[] output_names) {
        return null;
    }

    public String[] MakeHuffCode(String[] codeMap, NodeTree root, String str){ //A recursive function to Create a Huffman Tree
        
    	if (root.Isleaf()){ //Stop if we got to the character
    		codeMap[root.ch] = str + '$'; //Enter her bits in our Huffman code to her representative index
        }
        
        else
        {
        	MakeHuffCode(codeMap, root.leftNode, str + '0'); //If we go left we add a '0' according to Huffman
            MakeHuffCode(codeMap, root.rightNode, str + '1'); //If we go left we add a '1' according to Huffman
        }
        
        return codeMap; //return the decoding Huffman code
    }
    
   

}
