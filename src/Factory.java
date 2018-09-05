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
 * 多方法工厂（常用），可以构建有参构造函数
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

/**
 * 普通工厂，每个子类添加一个工厂，添加子类时添加一个工厂子类，可以构造有参构造函数
 */
abstract class ITaskFactory{
    public abstract ITask create();
}

class JavaTaskFactory extends ITaskFactory{
    @Override
    public ITask create() {
        return new JavaTask();
    }
}

class SqlTaskFactory extends ITaskFactory{
    @Override
    public ITask create() {
        return new SqlTask();
    }
}

class AlgoTaskFactory extends ITaskFactory{
    @Override
    public ITask create() {
        return new AlgorithmTask();
    }
}

public class Factory{
    public static void main(String[] args) {
        ITask javatask = (new JavaTaskFactory()).create();
        javatask.desc();

        ITask algotask = (new AlgoTaskFactory()).create();
        algotask.desc();
    }
}
