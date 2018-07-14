package priv.MyBlog.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeUtil {

	public static byte[] serialize(Object object) {
		byte[] result = null;
		ObjectOutputStream oos = null;
        ByteArrayOutputStream baos = null;
        try {
        	baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
			oos.writeObject(object);
			result = baos.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				baos.close();
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public static Object unserialize(byte[] bytes) {
		ByteArrayInputStream bais = null;
		Object object = null;
		ObjectInputStream ois = null;
		
		bais = new ByteArrayInputStream(bytes);
        try {
	        ois = new ObjectInputStream(bais);
			object = ois.readObject();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				bais.close();
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}
        return object;
	}
}
