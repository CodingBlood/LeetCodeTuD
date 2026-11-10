/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        int importance=0;
        for(Employee e: employees){
            if(e.id==id){
                importance+=e.importance;
                for(int i=0;i<e.subordinates.size();i++){
                    importance+=getImportance(employees,e.subordinates.get(i));
                }
            }
        }
        return importance;
    }
}