package com.cht.framework.core.transcoder;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;

import org.apache.commons.io.IOUtils;

import com.cht.framework.core.exception.SystemException;

/**
 * 进行序列化与反序列化的代码转换器
 * @author WJK
 * @version 2015-02
 * @deprecated 序列化效率不高且可读性差
 */
public class SerializeTranscoder <T extends Serializable> {
    /**
     * 功能:将二进制数据反序列化为集合对象
     * @param data
     * @param list
     */
    @SuppressWarnings("unchecked")
    public Collection<T> deserialize(byte[] data, Collection<T> collection) {
        ByteArrayInputStream bis = null;
        ObjectInputStream is = null;
        try {
            if (data != null) {
                bis = new ByteArrayInputStream(data);
                is = new ObjectInputStream(bis);
                while (true) {
                    T m = (T) is.readObject();
                    if (m == null) {
                        break;
                    }
                    collection.add(m);
                }
                is.close();
                bis.close();
            }
            return collection;
        } catch (Exception e) {
            throw new SystemException(e);
        } finally {
            IOUtils.closeQuietly(is);
            IOUtils.closeQuietly(bis);
        }
    }

    /**
     * 功能:将二进制数据反序列化为对象
     * @param list
     * @return
     */
    @SuppressWarnings("unchecked")
    public T deserialize(byte[] data) {
        T result = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream is = null;
        try {
            if (data != null) {
                bis = new ByteArrayInputStream(data);
                is = new ObjectInputStream(bis);
                result = (T) is.readObject();
                is.close();
                bis.close();
            }
        } catch (Exception e) {
            throw new SystemException(e);
        } finally {
            IOUtils.closeQuietly(is);
            IOUtils.closeQuietly(bis);
        }
        return result;
    }
    
    /**
     * 功能:将集合对象序列化为二进制数据
     * @param collection
     * @return
     */
    public byte[] serialize(Collection<T> collection) {
        if (collection == null){
            throw new NullPointerException("Can't serialize null");
        }
        byte[] results = null;
        ByteArrayOutputStream bos = null;
        ObjectOutputStream os = null;

        try {
            bos = new ByteArrayOutputStream();
            os = new ObjectOutputStream(bos);
            for (T m : collection) {
                os.writeObject(m);
            }
            os.writeObject(null);
            os.close();
            bos.close();
            results = bos.toByteArray();
        } catch (IOException e) {
            throw new SystemException(e);
        } finally {
            IOUtils.closeQuietly(os);
            IOUtils.closeQuietly(bos);
        }
        return results;
    }
    
    /**
     * 功能:将对象序列化为二进制数据
     * @param list
     * @return
     */
    public byte[] serialize(T value) {
        if (value == null) {
            throw new NullPointerException("Can't serialize null");
        }
        byte[] result = null;
        ByteArrayOutputStream bos = null;
        ObjectOutputStream os = null;
        try {
            bos = new ByteArrayOutputStream();
            os = new ObjectOutputStream(bos);
            os.writeObject(value);
            os.close();
            bos.close();
            result = bos.toByteArray();
        } catch (IOException e) {
            throw new SystemException(e);
        } finally {
            IOUtils.closeQuietly(os);
            IOUtils.closeQuietly(bos);
        }
        return result;
    }
}
