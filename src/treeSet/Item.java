package treeSet;

import java.util.Objects;

/**
 * @author WangPan wangpanhust@qq.com
 * @date 2018/11/11 19:11
 * @description
 **/
public class Item implements Comparable<Item>{

    private String description;
    private int partNumber;

    public Item(String aDescription,int aPartNumber){
        this.description = aDescription;
        this.partNumber = aPartNumber;
    }

    public String getDescription(){
        return description;
    }

    public String toString(){
        return "[description=" + description + ",partNumber=" + partNumber + "]";
    }

    public boolean equals(Object otherObject){
        //同一个对象，返回true
        if(this == otherObject){
            return true;
        }
        //null对象
        if(otherObject == null){
            return false;
        }
        //不是同一类
        if(this.getClass() != otherObject.getClass()){
            return false;
        }
        //都是Item类时对比description和partNumber
        Item other = (Item)otherObject;
        return Objects.equals(description,other.description) && partNumber == other.partNumber;

    }

    public int hashCode(){
        return Objects.hash(description,partNumber);
    }

    public int compareTo(Item other){
        int diff = Integer.compare(partNumber,other.partNumber);
        //三段式！
        return diff != 0 ? diff : description.compareTo(other.description);
    }

}