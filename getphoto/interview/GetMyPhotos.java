package interview;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;



public class GetMyPhotos {
//                                 http://images2.flashphotography.com/Magnifier/MagnifyRender.ashx?O=26780408&R=10003&F=0257&A=71994&rand=0.6941721790935844
//	public static String preUrl = "http://images2.flashphotography.com/Magnifier/MagnifyRender.ashx?O=26824977&F=0305&A=71994";
//	public static String basicUrl = "http://images2.flashphotography.com/Magnifier/MagnifyRender.ashx?O=26824977&A=71994";
	public static String basicUrl = "http://images2.flashphotography.com/Magnifier/MagnifyRender.ashx?O=26780408&A=71994";
	
	public static String preUrl;
	public static String f;
	
	public static String dir = "photos";
	
	public static void setMyPhoto(String f) {
		GetMyPhotos.f= f;
		preUrl = basicUrl+"&F="+f;
	}
	
	public static String getUrl(int x, int y, int photo) {
		return preUrl + "&X="+x+ "&Y="+y +"&R="+photo;
	}
	
	public static void saveAll() throws IOException{
		int pid = 10001;
		for ( int i=pid; i<10014;i++) {
			mergeImage(i);
		}
	}
	
	public static void  mergeImage(int photo) throws IOException {
		String fileName = f+"_"+photo+".jpg";
		System.out.println("Start downloading image " + fileName + "...");
		int  step = 50;
		int  row = 13;
		int  col = 10;		
		BufferedImage finalImg = new BufferedImage(480, 630,  BufferedImage.TYPE_INT_RGB);  
		for ( int i=0; i<row; i++) 
			for ( int j=0; j<col; j++) {
				BufferedImage buffImage = getSmallImage(step * j, step * i, photo);
				finalImg.createGraphics().drawImage(buffImage, step * j, step * i, null);  
			}		
		ImageIO.write(finalImg, "jpeg", new File(dir + "//"+fileName));  
		System.out.println("Complete  downloading image " + fileName + "!");
	}
	
	public static void  mergeImage2(int photo) throws IOException {
		String fileName = f+"_"+photo+".jpg";
		System.out.println("Start downloading image " + fileName + "...");
		int  step = 100;
		int  start = 58;
		int  row = 7;
		int  col = 5;		
		BufferedImage finalImg = new BufferedImage(480, 630,  BufferedImage.TYPE_INT_RGB);  
		for ( int i=0; i<row; i++) 
			for ( int j=0; j<col; j++) {
				BufferedImage buffImage = getSmallImage2(start+step * j, start+step * i, 100,37, photo);
				finalImg.createGraphics().drawImage(buffImage, step * j, step * i, null);  
			}		
		ImageIO.write(finalImg, "jpeg", new File(dir + "//"+fileName));  
		System.out.println("Complete  downloading image " + fileName + "!");
	}
	
	private static BufferedImage getSmallImage2(int x, int y, int len, int start, int photo) throws IOException {
		
		URL url = new URL(getUrl(x,y,photo));	   
	    BufferedImage src = ImageIO.read(url);
	    BufferedImage dest = src.getSubimage(start, start, len, len);
	    return dest; 
	}

	private static BufferedImage getSmallImage(int x, int y, int photo) throws IOException {
			
		URL url = new URL(getUrl(x,y,photo));	   
	    BufferedImage src = ImageIO.read(url);
	    BufferedImage dest = src.getSubimage(94, 94, 50, 50);
	    return dest; 
	}
	
	public static void getRange(String start , String end ) throws IOException {
		int si = Integer.parseInt(start);
		int ei = Integer.parseInt(end);
		for (int i=si; i<ei; i++) {
			String str = ""+i;
			if ( str.length()<4) {
				str = "0000".substring(0, 4-str.length())+i;
			}
			setMyPhoto(str);
			mergeImage2(10005);
		}
	}
	
	public static void getMy() throws IOException{
	//	setMyPhoto("0257");
	//	saveAll();
		setMyPhoto("0274");
		saveAll();
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// getRange("294","1000");
		getMy();
	}

}
