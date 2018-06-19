package test;

public class UserFunctionService {

    private FunctionService functionService;

    public void setFunctionService(FunctionService functionService) {
        this.functionService = functionService;
    }
    public FunctionService getFunctionService() {
        return functionService;
    }

    public String sayHello(String name){
        return functionService.sayHello(name);
    }
}
