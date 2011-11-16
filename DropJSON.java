import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class Mapping {
	String ClSz;
	String TotFq;
	String Root;
	String ClusterId;
	String QtFq;
	String Urls;
	String QtStr;
	String QuteId;
	String Tm;
	String Fq;
	String UrlTy;
	String Url;
	
	Mapping(String cl, String to, String ro, String clu, String qt, String ur, String qts, String qut, String tm, String fq, String urlt, String url){
		ClSz = cl;
		TotFq = to;
		Root = ro;
		ClusterId = clu;
		QtFq = qt;
		Urls = ur;
		QtStr = qts;
		QuteId = qut;
		Tm = tm;
		Fq = fq;
		UrlTy = urlt;
		Url = url;
		return;
	}
}

class DropJSON {
    public static void main(String[] args) {
        String line;
		String lineJSON = "[";

        try {
        	FileReader in = new FileReader("data.txt");
        	BufferedReader br = new BufferedReader(in);
            String[] array = new String[12];
        	String[] array_tmp;
    		int i = 0;
            while ((line = br.readLine()) != null) {
            	array_tmp = line.split("\t");
            	switch (array_tmp.length){
            	case 4:
            		array[0] = array_tmp[0];
            		array[1] = array_tmp[1];
            		array[2] = array_tmp[2];
            		array[3] = array_tmp[3];
    				break;
            	case 5:
            		array[4] = array_tmp[1];
            		array[5] = array_tmp[2];
            		array[6] = array_tmp[3];
            		array[7] = array_tmp[4];
            		array_tmp = null;
    				break;
            	case 6:
            		i++;
            		array[8] = array_tmp[2];
            		array[9] = array_tmp[3];
            		array[10] = array_tmp[4];
            		array[11] = array_tmp[5];
            		array_tmp = null;
                    Mapping value = new Mapping(array[0],array[1],array[2],array[3],array[4],array[5],array[6],array[7],array[8],array[9],array[10],array[11]);
            		if(i == 50){
            			i = 0;
            			System.out.print(lineJSON);
                        lineJSON = null;
                        lineJSON = "{\"ClSz\":" + value.ClSz + ", \"TotFq\":" + value.TotFq +
                				", \"Root\":\"" + value.Root + "\", \"ClusterId\":" + value.ClusterId +
                				", \"QtFq\":" + value.QtFq + ", \"Urls\":" + value.Urls + ", \"QtStr\":\"" +
                				value.QtStr + "\", \"QuteId\":" + value.QuteId + ", \"Tm\":\"" + value.Tm +
                				"\", \"Fq\":" + value.Fq + ", \"UrlTy\":\"" + value.UrlTy + "\", \"Url\":\"" + 
                				value.Url +"\"},";
            		}else{
                        lineJSON += "{\"ClSz\":" + value.ClSz + ", \"TotFq\":" + value.TotFq +
                				", \"Root\":\"" + value.Root + "\", \"ClusterId\":" + value.ClusterId +
                				", \"QtFq\":" + value.QtFq + ", \"Urls\":" + value.Urls + ", \"QtStr\":\"" +
                				value.QtStr + "\", \"QuteId\":" + value.QuteId + ", \"Tm\":\"" + value.Tm +
                				"\", \"Fq\":" + value.Fq + ", \"UrlTy\":\"" + value.UrlTy + "\", \"Url\":\"" + 
                				value.Url +"\"},";
                        }
    				break;
            	}
            }
            br.close();
            in.close();
            
        } catch (IOException e) {
            System.out.println(e);
        }
        lineJSON += "Last";
        lineJSON = lineJSON.replace(",Last","]");
        System.out.print(lineJSON);

    }
}
