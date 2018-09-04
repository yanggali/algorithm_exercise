abstract class ITask{
    public abstract void desc();
}

class JavaTask extends ITask{
    @Override
    public void desc() {
        System.out.println("要复习java");
    }
}

class SqlTask extends ITask{
    @Override
    public void desc() {
        System.out.println("要复习sql");
    }
}
class AlgorithmTask extends ITask{
    @Override
    public void desc() {
        System.out.println("要复习算法");
    }
}

/**
 * 简单工厂无法传入参数
 */
class SimpleFactory {
    public static <T extends ITask> T createTask(Class<T> clz){
        T result = null;
        try {
            result = (T) Class.forName(clz.getName()).newInstance();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return result;
    }

    public static void main(String[] args) {
        ITask javatask = SimpleFactory.createTask(JavaTask.class);
        javatask.desc();

        ITask sqltask = SimpleFactory.createTask(SqlTask.class);
        sqltask.desc();
    }
}

/**
 * 多方法工厂
 */
class MultiFactory{
    public static ITask createJavaTask(){
        return new JavaTask();
    }
    public static ITask createSqlTask(){
        return new SqlTask();
    }
    public static ITask createAloTask(){
        return new AlgorithmTask();
    }

    public static void main(String[] args) {
        ITask javatask = MultiFactory.createJavaTask();
        javatask.desc();

        ITask sqltask = MultiFactory.createSqlTask();
        sqltask.desc();
    }
}
