package mypackage;

class ContextHolder {
    private static Context instance;

    static void initializeContext(){
        instance = new Context()
    }

    static Context getContext() {
        return instance
    }
}
