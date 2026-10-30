package com.imlyb.tlias.exception;

public class ClazzHasStudentsException extends RuntimeException {
    public ClazzHasStudentsException(Integer clazzId) {
        super("班级[ID=" + clazzId + "]仍有关联学员，请先删除关联学员");
    }

    public ClazzHasStudentsException(String message) {
        super(message);
    }
}
