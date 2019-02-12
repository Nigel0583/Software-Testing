public class Robot {
    private String name;
    private int age;
    private boolean working = false;

    public Robot(String name, int age) {
        setName(name);
        setAge(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isEmpty()){
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age <= 30) {
            this.age = age;
        } else {
            throw new IllegalArgumentException();

        }

    }
    public String checkage() {
        if (age <= 20) {
            return "Age ok";
        } else {
            return "Too old";
        }
    }

    public boolean isWorking(){
        return working;
    }

    public void talkToRobot(){
        working = true;
    }

    public String getWorkingMessage(){
        if (!working){
            throw new IllegalStateException();
        }
        return "I am in working mode";
    }

    public void waitTillWorking(){
        while (!working){
            //do nothing
        }
    }

    public double checkCost() {
        if (age <= 5) {
            return 10000.00;
        } else if (age <= 10) {
            return 7500.00;
        } else return 5000.00;
    }

}
