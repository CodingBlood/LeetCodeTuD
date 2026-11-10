/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int helper(Employee e, Map<Integer, Employee> mp) {
        int importance=e.importance;
        for (int i = 0; i < e.subordinates.size(); i++) {
            importance += helper(mp.get(e.subordinates.get(i)), mp);
        }
        return importance;
        
    }

    public int getImportance(List<Employee> employees, int id) {
        int importance = 0;
        Map<Integer, Employee> mp = new HashMap<>();
        for (Employee e : employees) {
            mp.put(e.id, e);
        }
        importance = helper(mp.get(id), mp);

        return importance;
    }
}