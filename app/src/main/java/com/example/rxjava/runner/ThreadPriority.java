package com.example.rxjava.runner;

/**
 * 优先级。  Thread管理根据该优先级处理runnable。<br>
 */
public enum ThreadPriority {

    /**
     * 低优先级<br>
     */
    LOW,
    /**
     * 普通优先级<br>
     */
    NORMAL,
    /**
     * 高优先级<br>
     */
    HIGH,
    /**
     * 最高优先级<br>
     */
    IMMEDIATE
}
