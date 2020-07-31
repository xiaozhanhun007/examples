#### 概述

- 依赖倒置原则让高层和底层实现解耦。
- 高层和底层都依赖于抽象接口，但是抽象接口的所有者是高层，由高层定义接口，底层实现接口
（有别与现在普遍的分层模式，controller - service - dao，这些分层的接口所有是底层而不是高层）。

#### 例子

- 用按钮控制灯的开和关。
    - 按钮和灯是核心类，先抽象出核心类拥有的属性和方法。
    - 考虑核心类之间的关系，按钮和灯之间可以相互独立存在，并不存在组合的关系，所以这两个核心类不应该出现依赖关系，
    按钮需要调用灯，按钮属于高层，灯属于底层，可以在两者之间定义一个抽象接口（用于两者的解耦），该接口由高层（按钮）定义，灯实现该接口
    即可。