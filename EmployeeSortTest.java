package ds;
import java.util.*;    
public class EmployeeSortTest {    
   
    /**   
     * @param args   
     */   
    public static void main(String[] args) {    
        // TODO Auto-generated method stub    
        Employee[] staff = new Employee[3];    
        staff[0] = new Employee("harry Hacker",35000);    
        staff[1] = new Employee("carl cracke",75000);    
        staff[2] = new Employee("tony Tester",38000);    
            
        Arrays.sort(staff);//sort��������ʵ�ֶԶ����������򣬵��Ǳ���ʵ��                 Comparable�ӿ�    
                           /*Comparable�ӿ�ԭ��Ϊ��   
                            * public interface Comparable<T>   
                            * {   
                            *      int compareTo��T other);//�ӿڵ��з����Զ�����public����   
                            * }   
                            */   
        for(Employee e: staff)    
            System.out.println("id=" + e.getId() + " name=" + e.getName()+    
                    ".salary=" + e.getSalary());    
        
    }    
   
}    
/*   
 * ��ΪҪʵ�ֶ�Employee���������������Employee����Ҫʵ��Comparable�ӿڣ�   
 * Ҳ����Ҫʵ��comepareTo()����   
 */   
class Employee implements Comparable<Employee>    
{    
    public Employee(String n, double s)    
    {    
        name = n;    
        salary = s;    
        Random ID = new Random();    
        id = ID.nextInt(10000000);    
    }    
    public int getId()    
    {    
        return id;    
    }    
    public String getName()    
    {    
        return name;    
    }    
        
    public double getSalary()    
    {    
        return salary;    
    }    
        
    public void raiseSalary(double byPercent)    
    {    
        double raise  = salary *byPercent/100;    
        salary += raise;    
    }    
        
    public int compareTo(Employee other)    
    {    
        if(id<other.id)//����Ƚϵ���ʲô sort����ʵ�ֵľ��ǰ��մ˱ȽϵĶ�����С��������    
            return -1;    
        if(id>other.id)    
            return 1;    
        return 0;    
    }    
    private int id;    
    private String name;    
    private double salary;    
}  

