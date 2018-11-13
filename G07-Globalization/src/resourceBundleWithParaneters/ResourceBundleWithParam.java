package resourceBundleWithParaneters;

import java.text.ChoiceFormat;
import java.text.MessageFormat;
import java.util.Date;


public class ResourceBundleWithParam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		/** Ta titt på 
		 *  http://karlagius.com/2009/12/09/message-formatting-in-java/ 
		 *  https://docs.oracle.com/javase/7/docs/api/java/text/MessageFormat.html
		 * **/
		String msg  = "Invalid password entered. You have {0,number,integer} {0,choice, 1#attempt|1<attempts} remaining.";
		int attemptCount = 2; 
		System.out.println(MessageFormat.format(msg, attemptCount, attemptCount));
		
		System.out.println("******************************************************************************");
		
		
		 String event = "a disturbance in the Force";
		 String msg1 = "At {1,time} on {1,date}, there was {2} on planet {0,number,integer}."; 
		 String result = MessageFormat.format(msg1, 7, new Date(), event);
		 System.out.println(result);
		 
		 System.out.println("******************************************************************************");

		 String diskName = "MyDisk";
		 String msg3 = "The disk {1} contains {0,choice,0#no files|1#one file|1<{0,number,integer} files}.";
		 System.out.println(MessageFormat.format(msg3,0,diskName));
		 System.out.println(MessageFormat.format(msg3,1,diskName));
		 System.out.println(MessageFormat.format(msg3,10,diskName));

		 
		 System.out.println("******************************************************************************");

		 
		 MessageFormat form = new MessageFormat("The disk \"{1}\" contains {0}.");
		 double[] filelimits = {0,1,2};
		 String[] filepart = {"no files","one file","{0,number} files"};
		 ChoiceFormat fileform = new ChoiceFormat(filelimits, filepart);
		 form.setFormatByArgumentIndex(0, fileform);

		 int fileCount = 1273;
		 String diskName1 = "MyDisk";
		 Object[] testArgs = {new Long(fileCount), diskName1};

		 System.out.println(form.format(testArgs));

	}

}
