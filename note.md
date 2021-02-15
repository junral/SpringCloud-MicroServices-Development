# Spring Cloud 微服务架构开发实战

## 微服务概述

### 传统软件行业面临的挑战

软件危机：虽然采用团队协作，但软件开发的方法基本上仍然沿用早期的个体化软件开发方式，这样导致的问题是软件的数量急剧膨胀，然简需求日趋复杂，软件的维护难度也越来越大，开发成本变得越来越高，从而导致软件项目频频遭遇失败，就演变成了“软件危机”。

#### 软件危机概述

软件工程：“软件工程”的目的是要把软件开发从“艺术”和“个体行为”向“工程”和“群体协同工作”进行转化，从而解决“软件危机”。

软件工程包含以下两个方面的问题：

1. 如何开发软件，以满足不断增长、日趋复杂的需求。
2. 如何维护数量不断增长的软件产品。

在软件可行性分析方面，首先对软件进行可行性分析，可以有效地规避失败的风险，提高软件开发的成功率。

在需求方面，软件行业的规范是，需要制定相应的软件规格说明书、软件需求说明书，从而让开发工作有了依据，划清了开发边界，并在一定程度上减少了“需求蔓延”情况的发生。

在架构设计方面，需要指定软件架构说明书，划分系统之间的界限，约定系统间的通信接口，并将系统分为多个模块。这样更容易将任务分离，从而降低系统的复杂性。

#### 软件架构的发展

在设计分布式系统时，需要考虑的挑战：

* 异构性：分布式系统由于基于不同的网路、操作性、计算机硬件和编程语言来构造，必须要考虑一种通用的网络通信协议来屏蔽系统之间的差异。一般交由中间件来处理这些差异。
* 缺乏全球时钟：在程序需要协作时，它们通过交换消息来协调它们的动作。紧密的协调经常依赖于对程序动作发生时间的共识，但是，实际上网络上计算机同步时钟的准确性收到极大的限制，即没有一个正确时间的全局概念。这是通过网络发送消息作为唯一的通信方法这一事实带来的直接结果。
* 一致性：数据被分散或复制到不同机器上，如何保证各台主机之间数据的一致性将作为一个难点。
* 故障的独立性：任何计算机都有可能发生故障，且各种故障不尽相同。它们之间出现故障的时机也是相互独立的。一般分布式系统要设计成被允许出现部分故障，而不影响整个系统的正常使用。
* 并发：分布式系统的目的是更好地共享资源。那么系统中的每个资源都必须被设计成在并发环境中是安全。
* 透明性：分布式系统中任何组件的故障，后者主机的升级和迁移对于用户来说都是透明的，不可见的。
* 开放性：分布式系统由不同的程序员类编写不同的组件，组件最终要集成一个系统，那么组件所发布的接口必须遵守一定的规范且能够被相互理解。
* 安全性：加密用于给共享资源提供适当的保护，在网络上所有传递的敏感消息，都需要进行加密。拒绝服务攻击仍然是一个有待解决的问题。
* 可扩展性：系统要设计成随着业务量的增加，相应的系统也必须要扩展来提供对应的服务。

#### 人的因素

在传统的项目中，往往会较少关注人的因素。其实，人的心里决定了做事的质量。

#### 技术的迭代创新

#### 数据成为基础设施

#### 开发方式的转变

早些年，瀑布模型还是标准的软件开发模型。瀑布模型将软件生命周期分为制订计划、需求分析、软件设计、程序编写、软件测试和运行维护六个基本活动，并且规定了它们自上而下、相互衔接的固定次序，如同瀑布流水，逐级下降。

瀑布模型的优点是严格遵循预先计划的步骤顺序进行，一切按部就班，整个过程比较严谨。同时，瀑布模型强调文档的作用，并要求每个阶段都要仔细验证文档的内容。但是，这种模型的先性过程太过理想化。

瀑布模型主要存在的问题：

* 各个阶段的划分完全固定，阶段之间产生大量的文档，极大地增加了工作量。
* 由于开发模型是线性的，用户只有等到整个过程的末期才能见到开发效果，从而增加了开发的风险。
* 早期的错误可能要等到开发后期的测试才能发现，进而带来严重的后果。
* 各个软件生命周期衔接花费的时间较长，团队人员交流成本大。

### 常见分布式系统架构

#### 分布式对象体系

1. **DCOM(COM+)**

    DCOM（Distributed Component Object Model）是COM的扩展，它支持不同的两台机器上组件间的通信，而且无论它们是运行在局域网、广域网，还是Internet上。借助DCOM的应用程序将能够进行任意空间分布。由于DCOM是为了支持访问远程COM对象，需要创建一个对象的过程，此时需要提供服务器的网络名及类ID。

    由于DCOM是COM这个组件技术的无缝升级，所以能够从现有的有关COM的知识获益，以前的COM中开发的应用程序、组件、工具都可以移入分布式的环境中。DCOM将屏蔽底层网络协议的细节，只要集中精力于应用。

    DCOM最大的缺点是，这是微软独家的解决办法，但在跨防火墙方面的工作做得不是很好，因为防火墙必须允许某些短裤哦来让ORPC和DCOM通过。

2. **CORBA**

    传统同的远程过程调用的机制存在一些缺陷。

    CORBA（Common Object Request Broker Architecture）就是为了解决这些问题而出现的。
    CORBA是由OMG组织（对象管理组织）制定的一种标准的面向对象应用程序体系的规范。
    或者说，CORBA体系结构是OMG是为解决分布式处理环境（DCE）中，硬件和软件系统的互连而提出的一种解决方案。

    CORBA体系的主要内容包括：

    * 对象请求代理（Object Request Broker，ORB）：负责对象在分布环境中透明地收发请求和响应，它是构建分布对象应用、在异构或同构环境下实现的应用间互操作的基础。
    * 对象服务（Object Services）：为使用和实现对象而提供的基本对象集合，这些服务独立于应用领域。主要的CORBA服务有：名录服务（Naming Service）、事件服务（Event Service）、生命周期服务（Life Cycle Service）、关系服务（Relationship Service）及事务服务（Transaction Service）等。这些服务几乎包括分布系统和面向对象系统的各个方面，每个组成部分非常复杂。
    * 公共设施（Common Facilities）：向终端用户提供一组共享服务接口，入系统管理、组合文档和电子邮件等。
    * 应用接口（Application Interfaces）：由销售商提供的可控制其接口的产品，相应于传统的应用层表示，处于参考模型额最高层。
    * 领域接口（Domain Interfaces）：为应用领域服务而提供的接口。

    当客户端发出请求时，ORM做了如下事情：

    * 在客户端编组参数。
    * 定位服务器对象。如果有必要的话，它会在服务器创建一个过程来处理请求。
    * 如果服务器是远程的，就使用RPC或socket来传送请求。
    * 在服务器上将参数解析称为服务器格式。
    * 在服务器上组装返回值。
    * 如果服务器是远程的，就将返回值传回。
    * 在客户端对返回结果进行解析。

    IDL（Interface Definition Language）用于指定类的名字、属性和方法。它不包含对象的实现。IDL编译器生成代码来处理编组、解封及ORB与网络之间的交互。它会生成客户机和服务器存根，IDL是编程语言中立的，也就是说跟具体的编程语言实现无关。

    示例：

    ```idl
    Module StudentObject {
        Struct StudentInfo {
            String name;
            int id;
            float gpa;
        };
        exception Unknown {};
        interface Student {
            StudentInfo getinfo(in string name) raise(unknown);
            void putinfo(in StudentInfo data);
        }
    }
    ```

    IDL数据类型包括如下几种：

    * 基本类型：long、short、string、float等。
    * 构造类型：struct、union、枚举、序列。
    * 对象引用。
    * any类型：一个动态类型的值。

    CORBA的不足之处：

    * 尽管由多家供应商提供CORBA产品，但是仍然找不到能够单独为异种网络中的所有环境提供实现的供应商。不同的CORBA实现之间会出现缺乏互操作性的现象，从而早成一些问题。
    * CORBA过于复杂，要熟悉CORBA，并进行相应的设计和编程，需要很多个月来掌握，而要达到专家水平，则需要好几年。

3. **Java RMI**

    Java在其最初只支持通过socket来实现分布式通信。Sun公司开始提供创建一个Java扩展，称为Java RMI（Remote Method Invocation，远程方法调用）。Java RMI允许程序员通过创建分布式应用程序时，可以从其他Java虚拟机（JVM）调用远程对象的方法。

    Java RMI的设计目标如下：

    * 能够适应语言、继承到语言、易于使用。
    * 支持服务器到applet的回调。
    * 保障Java对象的安全环境。
    * 支持分布式垃圾回收。
    * 支持多种传输。

    分布式对象模型与本地Java对象模型的相似点如下：

    * 引用一个对象可以作为参数传递或作为返回的结果。
    * 远程对象可以投到任何使用Java语法实现的远程接口的集合上。
    * 内置Java instanceof操作符可以用来测试远程对象是否支持远程接口。

    分布式对象模型与本地Java对象模型的不同点：

    * 远程对象的类是与远程接口进行交互，而不是与这些接口的实现类交互。
    * Non-remote参数对于远程方法调用来说是通过复制，而不是通过引用。
    * 远程对象是通过引用来传递，而不是复制实际的远程实现。
    * 客户端必须处理额外的异常。

    使用RMI时，所有的远程接口都继承java.rmi.Remote接口。
    示例：

    ```java
    public interface bankAccount extends Remote {
        public void deposit(float amount) throws java.rmi.RemoteException;
        public void withdraw(float amount) throws OverdrawnException, java.rmi.RemoteException;
    }
    ```

    java.rmi.service.RemoteObject类提供了远程对象，实现的语义包括hashCode、equals和toString。java.rmi.server.RemoteServer及其子类提供让对象实现远程可见。java.rmi.server.UnicastRemoteObject类定义了客户机和服务器对象实例建立一对一的连接。

    Java RMI通过创建存根函数来工作。存根由rmic编译器生成。

    引用名称服务提供了用于存储远程对象的命名引用。一个远程对象可以存储使用类java.rmi.Naming提供的基于URL的方法。

    RMI的另一个优势在于，它自带分布式垃圾回收机制。根据Java虚拟机的垃圾回收机制原理，在分布式环境下，服务器进程需要知道哪些对象不再由客户端引用，从而可以删除（垃圾会说）。在JVM中，java使用引用计数，当引用计数归零时，对象将会垃圾回收。

#### 面向服务的架构

面向服务器的架构（Service Oriented Architecture，SOA）基于服务组件模型，将应用程序的不同功能单元（称为服务）通过定义良好的接口契约联系起来，接口是采用中立方式进行定义的，独立于实现服务的硬件平台、操作系统和编程语言，使构建在这样系统中的服务可以以一种统一和通用的灵活方式进行交互。

SOA组件模型具备的特点：

* 可重用：一个服务器创建后能用于多个应用和业务流程。
* 松耦合；服务请求者到服务提供者的绑定与服务之间应用是松耦合的。因此，服务请求者不需要知道服务提供者实现的技术细节，如程序语言、底层平台等。可执行服务的网络物理位置，只需知道服务名与服务接口即可。服务的部署、迁移和扩容极其便利。
* 明确定义的服务接口：服务交互必须是明确定义的。SOA服务组件提供标准周知的服务接口，服务请求者根据服务名和标准服务接口获取服务。Web服务描述语言（Web Services Description Language，WSDL）用于描述服务请求者所要求的绑定到服务提供者的细节。WSDL不包括服务实现的任何技术细节。服务请求者不知道也不关心服务究竟是由哪种程序设计语言编写的。
* 基于开方标准：当前SOA的实现形式基于开发标准，例如，共有Web Service协议，或私有开方服务标准协议。
* 无状态的服务设计：服务应该是独立的、自包含的请求，在实现时它不需要获取从一个请求到另一个请求的信息或状态。服务不应该依赖于其他服务的上下文状态。当产生依赖时，它们可以定义通用业务流程、函数和数据模型。

1. **SOA的定义和组成**

    定义：SOA是一个软件架构，包含四个关键概念：应用程序前端、服务、服务库和服务总线，一个服务包含一个合约、一个或多个接口即一个实现。

    * 应用服务前端：业务流程的所有者；
    * 服务：提供业务的功能，可以供应用程序前端后其他服务使用；
    * 实现：提供业务的逻辑和数据；
    * 合约：微服务客户指定功能、使用和约束；
    * 接口：物理地公开功能；
    * 服务库：存储SOA中各个服务的服务合约；
    * 服务总线：将应用程序前端和服务连在一起。

2. **SOA的角色**

    * 服务请求者（Service Customer）：服务请求者是一个应用程序、一个软件模块后需崖一个服务的另一个服务。它发起对服务管理中心中的服务查询（服务寻址），通过服务寻址后，与目标服务建立通道绑定服务，调用远程接口功能。服务请求者根据服务接口契约来获取执行远程服务。
    * 服务提供者（Service Provider）：服务提供者是一个可通过网络寻址的进程实体（脱管服务进程），与部署在脱管服务进程下的SOA服务组件一起实现服务功能。服务提供者将自动服务组件提供的服务名发不到服务注册中心，以便服务请求者可以发现和访问该服务。服务提供者接收和执行来自请求者的请求，通过接口提供服务。
    * 服务管理中心（Service Management Center）：服务管理中心是服务提供者与服务请求者的联系中介，提供服务提供者的服务注册管理，同时提供服务请求者的服务寻址查询。提供服务管理域中全部服务资源注册管理表，以及服务查询请求接口，允许感兴趣的服务请求者查找服务资源。SOA体系结构中的每个实体都扮演着服务提供者、请求者和管理中心这三个角色中的某一种（或多种）。

    SOA 体系结构中的操作：

     * 服务注册：为了使服务可访问，需要服务提供者向服务管理中心注册服务，以使服务请求者可以发现和调用它。
     * 服务寻址：服务请求者定位服务，方法是查询服务注册中心来找到满足其服务需求的服务资源网络地址。
     * 服务交互（远程服务调用）：在完成服务寻址之后，服务请求者根据目标服务提供者建立的网络通道调用服务。

3. **基于Web Service的SOA**

    Web Service是SOA架构系统的一个实例，在SOA架构实现中应用非常广泛。

    Web Service称为一组协议，允许服务被发发布、发现，并用于技术无关形式。即服务不应该依赖与客户的语言、操作系统或机器架构。

    Web Service的实现一般都是使用Web服务器作为服务请求的管道。客户端访问该服务，首先是通过一个HTTP协议发送请求到服务器上的Web服务器。Web服务器配置识别URL的一部分路径名或文件名后缀并将请求传递给特定的浏览器插件模块。这个模块去除头、解析数据（如果需要），并根据需要调用其他函数或模块。

4. **Java中的XML Web Services**

    Java RMI与远程对象进行交互，其实现需要基于Java的模型。此外，它没有使用Web Service和基于HTTP的消息传递。现在，已经出现大量的软件支持基于Java的Web Services。JAX-WS（Java API for XML Web Services）就是作为Web Services消息和远程过程调用的规范。JAX-WS的一个目标是平台互操作性。其API使用SOAP和WSDL。双方不需要Java环境。

    在服务器端，创建一个RPC端点的操作步骤：

     * 定义一个接口（Java接口）。
     * 实现服务。
     * 创建一个发布者，用于创建服务的实例。并发布一个服务名字。

    在客户端的操作步骤：

     * 创建一个大力（客户端存根）。wsimport命令根据WSDL文档，创建一个客户机存根。
     * 编写一个客户端，通过代理创建远程服务的一个实例（存根），调用它的方法。

    JAX-RPC执行流程：

     * java客户机调用存根上的方法（代理）。
     * 存根调用适当的Web服务。
     * 框架调用实现。
     * 实现返回结果给Web服务器。
     * 服务器将结果饭会给客户端存根。
     * 客户端存根返回信息给调用者。

#### RESTful 风格的架构

1. **什么是REST**

    表述性状态转移（Representation State Transfer，REST）描述了一个架构样式的网络系统，比如Web应用程序。

    REST API应具备的条件：

     * REST API不应该依赖于任何通信协议，尽管要成功映射到某个协议可能会依赖于元数据的可用性、所选的方法等。
     * REST API不应该包含对通信协议的任何改动，除非是补充或确定标准协议中未规定的部分。
     * REST API应该将大部分的描述工作放在定义用于表示资源和驱动应用状态的媒体类型上，或定义现有标准媒体类型的扩展关系名和（或）支持超文本的标记。
     * REST API绝不应该定义一个固定的资源名或层次结构（客户端和服务器之间的明显耦合）。
     * REST API永远也不应该有那些会影响客户端的“类型化”资源。
     * REST API不应该要求有先验知识（Prior Knowledge），除了初始URI和适合目标用户的一组标准化的媒体类型（即它能被任何潜在使用该API的客户端理解）。

    REST并非标准，而是一种开发Web应用的架构风格，可以理解为一种设计模式。

2. **REST有哪些特征**

    * 通过URI来标识资源：系统中的每一个对象或资源都可以通过一个唯一的URI来进行寻址，URI的结构应该简单、可预测且易于理解。

    * 统一接口：以遵循RFC-2616所定义的协议方式显式地使用HTTP方法，建立创建、检索、更新和删除（CRUD：Create，Retrieve，Update and Delete）操作与HTTP方法之间的一对一映射。

    * 资源多重表述：URI所访问的每个资源都可以使用不同的形式加以表示（如XML或JSON），具体的表现形式取决于访问资源的客户端。客户端与服务提供者使用一种内容协商的机制（请求头与MIME类型）来选择合适的数据格式，最小化彼此之间的数据耦合。

        若要在服务器上创建资源，应该使用POST方法。

        若要检索某个资源，应该使用GET方法。

        若要更新或添加资源，应该使用PUT方法。

        若要删除某个资源，应该使用DELETE方法。

    * 无状态：对服务器端的请求应该是无状态的，完整、独立的请求不要求服务器在处理请求时检索任何类型的应用程序上下文或状态。无状态约束使服务器的变化对客户端是不可见的，因为在两次连续的请求中，客户端并不依赖于统一台服务器。一个客户端从某台服务器上收到一个包含连接的文档，当它要做一些处理时，这台服务器宕机了，可能是硬盘损坏而被拿去修理，可能是软件需要升级重启——如果这个客户端访问了从这台服务器接收的连接，它不会察觉到后台服务器已经改变了。通过超链接实现有状态交互，即请求消息是自包含的（每次交互都包含完整的信息），有多种技术实现了不同请求间状态信息的传输，如URI重新，Cookies和隐藏表单字段等，状态可以嵌入到应答消息里，这样一来状态在接下来的交互中仍然有效。

3. **Java REST 规范**

    针对RESt在Java中的规范，主要是JAX-RS（Java API for RESTful Web Services）。该规范使得Java程序员可以使用一套固定的接口来开发REST应用。避免了依赖于第三方框架。同时，JAX-RS使用POJO编程模型和基于标注的配置，并集成了JAXB，从而可以有效地缩短REST应用的开发周期。

#### 微服务架构及容器技术

微服务架构（Microservices Architecture，MSA）的诞生并非偶然，它的产生主要依赖于以下方面的内容：

* 领域驱动设计：知道我们如何分析并模型化复杂的业务。
* 敏捷方法论：帮助快速开发产品，形成有效反馈。
* 持续交付：促使我们构建更快、更可靠、更频繁的软件部署和交付能力。
* 虚拟化和基础设施自动化：特别是以Docker为代表的容器技术，帮助我们简化环境的创建和安装。
* DevOps：全功能化的小团队，让开发、测试、运维有效地整合起来。

1. **MSA特征**

    * 组件以服务形式来提供：正如其名，微服务也是面向服务的。
    * 围绕服务功能进行组织：微服务更倾向于围绕业务功能对服务结构进行划分、拆解。这样的微服务是针对特定业务领域的、有着完整实现的应用软件，它包含了使用的接口、持久化存储及对外的交互。因此微服务的团队应该是跨职能的，包含完整的开发技术、用户体验、数据库及项目管理。
    * 产品不是项目：传统的开发模式致力于提供一些被认为是完整的软件。一旦开发完成，软件将移交给维护或实施部门，然后开发组就可以解散了。而微服务要求开发团队对软件产品的整个生命周期负责。这要求开发者每天都关注软件产品的运行情况，并与用户联系得更紧密，同时承担一些售后支持。
    * 强化终端及弱化通道：微服务的应用致力于松耦合和高内聚，它们更喜欢简单的REST风格，而不是复杂的协议（如WS、BPEL或集中式框架）。或者采用轻量级消息总线（如RabbitMQ或ZeroMQ等）来发布消息。
    * 分散治理：这跟传统的集中式管理有很大区别的地方。微服务把整体式框架中的组件拆分成不同的服务，在构建它们时将会有更多的选择。
    * 分散数据管理：当整体式的应用使用单一逻辑数据库对数据持久化时，企业通常选择在应用的范围内使用一个数据库。微服务让每个服务管理自己的数据库，无论是相同数据库的不同实例，或者是不同的数据库系统。
    * 基础设施自动化：云计算，特别是AWS的发展，减少了构建、发布、运维微服务的复杂性。微服务团队更加依赖于基础设施的自动化，毕竟发布工作相当无趣。
    * 容错性设计：任何服务都可能因为供应商的不可靠而产生故障。微服务应为每个应用的服务及数据中心提供日常故障检测和恢复。
    * 改进设计：由于设计会不断更改，微服务所提供的服务应该能够替换或报废，而不是要长久地发展的。

2. **MSA与SOA的区别和联系**

    微服务架构（MSA）与面向服务架构（SOA）有相似之处，比如都是面向服务，通信大多是基于HTTP协议。
    通常传统的SOA意味着大而全的单块架构（Monolithic Architecture）的解决方案。这让设计、开发、测试、发布都增加了难度，其中任何细小的代码变更，都将导致整个系统需要重新测试、部署。
    而微服务架构恰恰把所有服务都打散，设置合理的颗粒度，各个服务间保持地耦合，每个服务都在其完整的生命周期中存活，把相互之间的影响降到最低。

    SOA的好处：

    * 易于开发：当前开发工具和IDE的目标就是支持这种单块应用的开发。
    * 易于部署：只要将WAR文件或目录结构放到合适的运行环境下即可。
    * 易于伸缩：只需要在负载均衡器下面运行应用的多份拷贝就可以伸缩。

    SOA的缺陷：

    * 代码库庞大：巨蛋的单块代码库可能会吓到开发者，尤其团队按的新人。应用难于理解和修改。因此，开发速度通常会减慢。另外，由于没有模块硬边界，模块化也随时间而破坏。另外，因为难以理解如何实现变更，代码质量也随时间下降。这个是恶性循环。
    * IDE超载：代码库越大，IDE越慢，开发者效率越低。
    * Web容器超载：应用越大，容器启动时间越长。因此，开发者大量的时间被浪费在等待容器启动上。这也会影响到部署。
    * 难以持续部署：对于频繁部署，巨大的单块应用也是个问题。为了更新一个组件，必须重新部署这个应用。这还会中断后台任务（如Java应用的Quartz作业），不管变更是否影响到这些任务，都有可能引发问题。未被更新的组件也可能因此而不能正常启动。因此，鉴于重新部署的相关风险会增加，不鼓励频繁更新。
    * 难以伸缩应用：单块架构只能在一个维度伸缩。一方面，它可以通过运行多个拷贝来伸缩以满足业务量的增加，某些云服务甚至可以动态地根据负载调整应用实例的数量。但是另一方面，该架构不能伸缩满足数据量的增加。每个应用实例都要访问全部数据，这使得缓存低效，而且提升了内存占用和I/O流量。而且，不同的组件所需资源不同，一些可能是CPU密集型的，另一些可能是内存密集型的。单块架构下，我们不能单独伸缩各个组件。
    * 难以调整开发规模：单块应用对调整开发规模也是个障碍。一旦应用达到了一定规模，将工程组织分成专注于特定功能模块的团队通常更有效。单块应用的问题是它阻碍组织团队相互独立地工作。团队之间必须在开发进度和重新部署上进行协调。对团队来说，也是很难改变和更新产品。
    * 需要对一个技术栈长期投入：单块架构迫使采用开发初期选择的技术栈（某些情况下，是那项技术的某个版本）。并且，在单块架构下，很难递增式采用更新的技术。

    微服务的好处：

    * 每个微服务都相对较小。
    * 每个微服务都可以独立部署，易于频繁部署新版本的服务。
    * 易于伸缩开发组织结构。可以对多个团队的开发工作进行组织。每个团队负责单个服务。每个团队可以独立于其他团队开发、部署和伸缩服务。
    * 提升故障隔离。
    * 每个服务可以单独开发和部署。
    * 消除了任何对技术栈的长期投入。

    微服务的缺陷：

    * 开发者要处理分布式系统的额外复杂度。
    * 开发者IDE大多是面向构建单块应用的，并没有显式提供对开发分布式应用的支持。
    * 测试更加困难。
    * 开发者需要实现服务间通信机制。
    * 不使用分布式事务实现跨服务的用例更加困难。
    * 实现跨服务的用例需要团队间的细致协作。
    * 生产环境的部署复杂度。对于包含多种不同服务类型的系统，部署和管理的操作复杂度仍然存在。
    * 内存消耗增加。微服务使用NxM个服务实例来替代N个单块应用的实例。如果每个服务运行在自己独立的JVM上，通常有必要对实例进行隔离，对这么多运行的JVM，就有M倍的开销。另外，如果每个服务运行在独立的虚拟机上，那么开销会更大。

3. **如何构建微服务**

### 单块架构如何进化为微服务架构

#### 单块架构的概念

软件系统经常会采用分层架构形式。所谓分层，是指将软件按照不同的职责进行垂直分化，最终软件会被分层为若干层。
Java EE软件经常采用经典的三层架构（Three Tier Architecture），即表现层、业务层和数据访问层。

三层架构中的不同层都拥有自己的单一职责。

* 表现层（Presentation Layer）：提供与用户交互的界面。GUI（图像用户介面）和Web页面是表现层的两个典型的例子。
* 业务层（Business Layer）：也称为业务逻辑层，用于实现各种业务逻辑。
* 数据访问层（Data Access Layer）：也称为数据持久层，负责存放和管理应用额持久性业务数据。

#### 单块架构的优缺点

SOA本质就是要通过统一的、与平台无关的通信方式，来实现不同服务之间的协同。这也是大型系统都会采用SOA架构的原因。

单块架构的优点：

* 层次关系良好：上层依赖于下层，而下层支撑起上层，但却不能直接访问上层，层与层之间通过协作来共同完成特定的功能。
* 每以层都保持独立：层能够被单独构造，也能被单独替换，最终不会影响整体功能。
* 部署简单：由于所有的功能都集合在一个发布包里面，所以将发布包进行部署都较为简单。
* 技术单一：技术相对比较单一，这样整个的开发学习成本比较低，人才复用率也比较高。

单块架构的缺点：

* 功能仍然太大：虽然SOA可以解决整体系统太大的问题，但每个子系统体量仍然是比较大的，而且随着时间的推移，会越来越大，毕竟功能会不断添加进来。最后，代码会变得太多，且难以管理。
* 升级风险高：因为是所有功能都在一个发布包里面，如果升级，就更换整个发布包。那么在升级的过程中，会导致整个应用停掉，致使所有的功能不可用。
* 维护成本增加：因为系统在变大，如果人员保持不变的话，每个开发人员都可能维护整个系统的每个部分。如果是自己在开发的功能还好。
* 项目交付周期变长：由于单块架构必须要等到最后一个功能测试没有问题了，才能整体上限，这就导致交付周期被拉长了。这就是“水桶理论”，只要有一个功能存在短板，整个系统的交付就会被拖累。
* 可伸缩性差：由于应用程序的所有功能代码都运行在同一个服务器上，将会导致应用程序的扩展非常困难。特别是，如果想扩展系统中的某以功能，但不得不对整个应用都水平进行了扩容，这就导致了其他不需要扩容的功能浪费。
* 监控困难：不同的功能都杂合在一个进程中，这就让监控这个进程的功能变得非常困难。

#### 如何将单块架构进化为微服务

将一个大服务继续拆分，称为不同的、不可再分的“服务单元”时，也就演变成为另一种架构风格——微服务架构。
所以，微服务架构本质上是一种SOA的特例。

### 微服务其架构的设计原则

#### 拆分足够微

将单体架构的应用拆分为微服务时，应考虑微服务的颗粒度问题。颗粒度太大，其实就是拆分得不够充分，无法发挥微服务的优势；如果拆分得太细，又会面临服务数量太多引起的服务管理问题。
当开发人员认为代码库过大时，往往就是拆分的最佳时机。代码库的大小不能简单地以代码量来评价，毕竟复杂业务功能的代码量，肯定比简单业务的代码量要高。同样地，一个服务，功能本身的复杂性不同，代码量也截然不同。一个经验是，一个微服务通常能够在两周内开发完成，且能够被一个小团队所维护；否则，则需要将代码进行拆分。

微服务也不是越小越好。服务越小，微服务架构的优点和缺点就会越来越明显。服务越小，微服务的独立性就会越高，但同时，微服务的数量也会激增，管理这些大批量的服务也将会是一个挑战。

#### 轻量级通信

在单体架构的系统中，组件通过简单的方法调用就能进行通信，但是微服务架构系统中，由于服务都是跨域进程，甚至是跨主机的，组件只能通过REST、Web服务或某些类似RPC的机制在网络上进行通信。

服务间通信应采用轻量级的通信协议，例如，同步的REST，异步的AMQP、STOMP、MQTT等。在实时性要求不高的情况下，采用REST服务的通信是不错的选择。REST基于HTTP协议，可以跨越防火墙的设置。其消息格式可以是XML或JSON，这样也方便开发人员来阅读和理解。

#### 领域驱动原则

应用程序功能分级可以通过Eric Evans在领域驱动设计（Domain-Driven Design）一书中明确定义的规则实现。

一个微服务，应该能反映出某个业务的领域模型。使用领域驱动设计（DDD），不但可以降低微服务环境中通用语言的复杂度，而且可以帮助团队搞清楚领域的边界，理清上下文边界。

建议将每个微服务都设计成一个DDD限界上下文（Bounded Context）。这为系统内的微服务提供了一个逻辑边界，无论是在功能，还是在通用语言上。每个独立的团队负责一个类逻辑上定义好的系统切片。

#### 单一职责原则

服务的划分遵循“高内聚、低耦合”，根据“单一职责原则”来确定服务的边界。

服务应当弱耦合在一起，对其他服务的依赖应尽可能低。一个服务与其他服务的任何通信都应该通过公开暴露的接口（即API、事件等）实现，这些接口需要妥善设计以隐藏内部细节。

服务应具备高内聚力。密切相关的多个功能应尽量包含在同一个服务中，这样可将服务之间的干扰降至最低。服务应包含单一的界限上下文。界限上下文可将某一领域的内部细节，包括该领域特定的模块封装在一起。

理想情况下，必须对自己的产品和业务有足够的了解才能确定最自然的服务边界。就算一开始确定的边界是错误的，服务之间的弱耦合也可以让你在未来轻松耦合（如合并、拆分、重组）。

#### DevOps及两个披萨

每个微服务的开发团队应该是小而精，并具备完全自治的全栈能力。团队拥有全系列的开发人员，具备用户界面、业务逻辑和持久化存储等方面的开发技能即能够实现独立的运维，这就是目前流行的DevOps的开发模式。

“两个披萨原则”有助于避免项目陷入停顿或失败的局面。领导人需要慧眼识才，找出能够让项目成功的关键人物，然后尽可能地给他们提供资源，从而推动项目向前发展。让一个小团队在一起做项目、开会研讨，更有利于达成共识，促进企业创新。

#### 不限于技术栈

在单体架构中，技术栈相对较为单一。而在微服务架构中，这种情况就会有很大的转变。

由于服务之间的通信，是跟具体的平台无关的，所以理论上，每个微服务都可以采用适合自己场景的技术栈。

#### 可独立部署

由于每个微服务都是独立运行在各自的进程中，这就给独立部署带来了可能。每个微服务部署到独立的主机或虚拟机中，可以有效实现服务间的隔离。

独立部署的另一个优势是，开发者不再需要协调其他服务部署对本服务的影响，从而降低了开发、测试、部署的复杂性，最终可以加快部署速度。

### 如何设计微服务系统

#### 服务拆分

服务拆分首先要关注的是服务的颗粒度。

通过DDD（领域驱动设计）的指导，我们可以将某个领域的功能进行聚合成为一个服务。这个服务只负责某一方面的功能。

对象并不是独立存在的，它们之间会存在着千丝万缕的联系。而正是这种联系构成了系统的复杂性。一个具体的体现就是，当我们修改了一处变更时，结果会引发一系列的连锁反应。虽然对象的封装机制可以帮我们解决一部分问题，但也只是有限的一部分。我们应该在一个更高点的层次上来思考，如何通过保留对象之间的关系去除无用的关系，并且限定变更影响的范围，来降低系统的复杂度。

#### 服务测试

1. 积极发布，及时得到反馈

    开发实践中，我们推崇持续继承和持续发布。持续集成和持续发布的成功实践，有利于形成“需求->开发->集成->部署”的可持续的反馈闭环，从而使需求分析、产品的用户体验和交互设计、开发、测试、运维等角色密切协作，减少了资源的浪费。

2. 增大自动化测试的比例

    最大化自动测试的比例有利于减少企业的成本，同时也有利于测试效率的提升。

3. 合理安排测试的介入时机

    测试工作应该要及早介入，一般人为，测试应该在项目立项时介入，并伴随整个项目的生命周期。在需求分析出来以后，，测试不只是对程序的测试，文档测试也是同样重要的。需求分析评审的时候，测试人员应该积极参与，因为所有的测试计划和测试用例都会以客户需求为准绳。需求不但是开发的工作依据，同时也是测试的工作依据。

#### 服务注册

微服务架构的特点就是服务的数量众多，这些服务需要一个统一的服务注册平台来进行服务的管理。每个微服务实例启动后，会将自己的实例告知给服务注册表或服务注册中心。服务的调用方若想获取到可用服务实例的列表，也是需要从服务注册表中去获取相关信息的。

当服务实例失效后，那么服务实例的信息就要从服务注册表中移除，这个过程称为服务注销。

当服务实例启动后，会将自己的位置信息提交到服务注册表（Service Registry）中。服务注册表就是用于维护所有可用的服务实例的地方。服务注册表一方面要接收微服务实例的接入，另一方面，当服务不可用时，也要及时将服务实例从服务注册表中清除。

为了保证可用性，服务注册表京城被配置为高可用而且需要与服务实例进行一定频率的通信，从而能够随时感知到服务实例的状态，及时来更新可用实例的列表。

Netflix Eureka提供了服务注册表的功能，而且提供了REST API来方便进行服务的注册。

Netflix Eureka客户端（包括服务和服务客户端），是查询DNS去发现Netflix Eureka服务的网络地址。客户端首选同一域内的Netflix Eureka服务。如果没有可用服务，客户端会使用其他可用域中的Netflix Eureka服务。

要想访问微服务，服务实例必须要现在注册表中进行注册。服务注册主要有两种不同的方法：一种是服务实例自己注册，也叫自注册模式（Self Registration）；另一种是采用管理服务实例注册的其他系统组件，即第三方注册模式（3rd Party Registration）。

#### 服务发现

微服务实例要想让其他服务调用方感知到，就需要服务发现机制。通过服务发现，调用方可以及时拿到可用服务实例的列表。

在微服务架构中，对于服务发现的需求是这样的：

* 微服务的部署，往往利用虚拟机的主机或容器技术，所分配的主机位置往往是虚拟的。
* 微服务的服务实例的网络位置往往是动态分配的。
* 微服务要满足容错和扩展等需求，因此服务实例会经常动态改变，这意味着服务的位置也会动态变更。
* 同一个服务往往会配置多个实例，需要服务发现机制来决定使用其中的哪个实例。

服务发现机制原理：

* 当服务实例启动后，将自己的位置信息提交到服务注册表中。服务注册表维护着所有可用的服务实例的列表。
* 客户端从服务注册表进行查询，来获取可用的服务实例。
* 在选取可用的服务实例的过程中，客户端自行使用负载均衡算法从多个服务实例中选择一个，然后发出请求。

Netflix提供了完整的服务注册即服务发现的实现方式。Netflix Eureka提供了服务注册表的功能，微服务实例注册管理和查询可用实例提供了REST API接口。Netflix Ribbon的主要功能是提供客户端的软件负载均衡算法，将Netflix的中间层服务连接在一起。Netflix Ribbon客户端组件提供一系列完善的配置项。

#### 服务部署与发布

当单体架构被划分成微服务后，随着微服务的数量增多，部署这么多的微服务毫无疑问将会面临比单体架构更复杂的问题。

* 运维负担。
* 服务间的依赖。
* 更多的监控。
* 更频繁的发布。
* 更复杂的测试。

微服务更倾向于使用具有相互之间隔离的主机或虚拟机来实现服务的部署。这样，服务就能够各自进行安装、部署在、测试、发布、升级，而这些动作对与其他服务来说是不可知的。如果服务之间有依赖关系，则可以通过逐个替换服务实例的方式来实现服务零停用。

一种比较好的方式是把微服务打包成镜像，这样就保证了主键之间能够使用相同的镜像。同时，由于镜像中包含了服务的配置文件和环境，这样就可以尽可能避免主键环境对软件部署产生的影响。

## 微服务的基石——Spring Boot

### Spring Boot简介

#### Spring Boot产生的背景

在Spring 4.0发布之后，Spring团队抽象出了Spring Boot开发框架。Spring Boot本身并不是提供Spring框架的核心特性及扩展功能，只是用于快速、敏捷地开发新一代基于Spring框架的应用程序。也就是说，Spring Boot并不是来替代Spring的解决方案，而是和Spring框架紧密结合，用于提升Spring开发者体验的工具。

#### Spring Boot的目标

简化Java企业应用是Spring Boot的目标宗旨。Spring Boot简化了基于Spring的应用开发，通过少量的代码就能创建一个独立的、产品级别的Spring应用。

可以使用Spring Boot创建Java应用，并使用java -jar启动它或者也可以采用传统的WAR部署方式。同时Spring Boot也提供了一个运行“Spring 脚本”的命令工具。

Spring Boot的主要目标：

* 为所有Spring开发提供一个更快更广泛的入门体验。
* 开箱即用，不合适时也可以快速抛弃。
* 提供一系列大型项目常用的非功能性特征，如嵌入式服务器、安全性、度量、运行状况检查、外部化配置等。
* 零配置。无冗余代码生成和XML强制配置，遵循“约定大于配置”。

#### Spring Boot与其他Spring应用的关系

1. Spring Boot与Spring框架的关系

    Spring框架通过IoC机制来管理Bean。Spring Boot依赖Spring框架来管理对象的依赖。Spring Boot并不是Spring的精简版本，而是使用Spring做好各种产品及准备。

    Spring Boot 本质上还是一个Spring应用，只是将各种依赖按照不同的业务需求来进行“组装”，称为不同的Starter。这样开发者不许自行配置不同的类库之间的关系，采用Spring Boot的Starter即可。

2. Spring Boot与Spring MVC框架的关系

    Spring MVC实现了Web项目中的MVC模式。如果Spring Boot是一个Web项目的话，可以选择采用Spring MVC来实现MVC模式。

3. Spring Boot与Spring Cloud框架的关系

    Spring Cloud框架可以实现一整套分布式系统的解决方案（当然其中也包括微服务架构的方案），包括服务注册、服务发现、监控等，而Spring Boot只是作为单一服务的架构的基础。

#### Starter

Spring Boot官方提供的Starter都以spring-boot-starter-\*方式来命名，其中\*是特定业务功能类型的应用程序。

Spring Boot官方提供的Starter主要分为三类：应用型的Starter、产品级别的Starter、技术型的Starter。

1. 应用型的Starter

    常用应用型的Starter包含：

    * spring-boot-starter：核心Starter包含支持auto-configuration、日志和YAML。
    * spring-boot-starter-activemq：使用Apache ActiveMQ来实现JMS的消息通道。
    * spring-boot-starter-amqp：使用Spring AMQP和RabbitMQ。
    * spring-boot-starter-aop：使用Spring AOP和AspectJ来实现AOP功能。
    * spring-boot-starter-artemis：使用Apache Artemis来实现JMS的消息通道。
    * spring-boot-starter-batch：使用Spring Batch。
    * spring-boot-starter-cache：启用Spring框架的缓存功能。
    * spring-boot-starter-cloud-connectors：用于简化连接到云平台，如Cloud Foundry和Heroku。
    * spring-boot-starter-data-cassandra：使用Cassandra和Spring Data Cassandra。
    * spring-boot-starter-data-couchbase：使用Couchbase和Spring Data Couchbase。
    * spring-boot-starter-data-elasticsearch：使用Elasticsearch和Spring Data Elasticsearch。
    * spring-boot-starter-data-jpa：使用基于Hibernate的Spring Data JPA。
    * spring-boot-starter-data-ldap：使用Spring Data LDAP。
    * spring-boot-starter-data-mongodb：使用MongoDB和Spring Data MongoDB。
    * spring-boot-starter-data-mongodb-reactive：使用MongoDB和Spring Data MongoDB Reactive。
    * spring-boot-starter-data-neo4j：使用Neo4j和Spring Data Neo4j。
    * spring-boot-starter-data-redis：使用Redis和Spring Data Redis，以及Jedis客户端。
    * spring-boot-starter-data-redis-reactive：使用Redis和Spring Data Redis Reactive，以及Lettuce客户端。
    * spring-boot-starter-data-rest：通过Spring Data REST来呈现Spring Data仓库。
    * spring-boot-starter-data-solr：通过Spring Data Solr来使用Apache Solr。
    * spring-boot-starter-freemarker：在MVC应用中使用FreeMarker视图。
    * spring-boot-starter-groovy-templates：在MVC应用中使用Groovy Templates视图。
    * spring-boot-starter-hateoas：使用Spring MVC和Spring HATEOAS来构建基于Hypermedia的RESTful服务应用。
    * spring-boot-starter-integration：用于Spring Integration。
    * spring-boot-starter-jdbc：使用Tomcat JDBC连接池来使用JDBC。
    * spring-boot-starter-jersey：使用JAX-RS和Jersey来构建RESTful服务应用，可以替代spring-boot-starter-web。
    * spring-boot-starter-jooq：使用jOOQ来访问数据库，可以替代spring-boot-starter-jpa或spring-boot-starter-jdbc。
    * spring-boot-starter-jta-atomikos：使用Atomikos处理JTA事务。
    * spring-boot-starter-jta-bitronix：使用Bitronix处理JTA事务。
    * spring-boot-starter-jta-narayana：使用Narayana处理JTA事务。
    * spring-boot-starter-mail：使用Java Mail和Spring框架的油煎发送支持。
    * spring-boot-starter-mobile：使用Spring Mobile来构建Web应用。
    * spring-boot-starter-mustache：使用Mustache视图来构建Web应用。
    * spring-boot-starter-quartz：使用Quartz。
    * spring-boot-starter-security：使用Spring Security。
    * spring-boot-starter-social-facebook：使用Spring Social Facebook。
    * spring-boot-starter-social-linkedin：使用Spring Social LinkedIn。
    * spring-boot-starter-social-twitter：使用Spring Social Twitter。
    * spring-boot-starter-test：使用JUnit、Hamcrest和Mockito来进行应用的测试。
    * spring-boot-starter-thymeleaf：在MVC应用中使用Thymeleaf视图。
    * spring-boot-starter-validation：启用基于Hibernate Validatior和Java Bean Validation功能。
    * spring-boot-starter-web：使用Spring MVC来构建RESTful Web应用，并使用Tomcat作为默认内嵌容器。
    * spring-boot-starter-web-services：使用Spring Web Services。
    * spring-boot-starter-webflux：使用Spring框架的Reactive Web支持来构建WebFlux应用。
    * spring-boot-starter-websocket：使用Spring框架的WebSocket支持来构建WebSocket应用。

2. 产品级别的Starter

    产品级别的Starter主要有Actuator。

    * spring-boot-starter-actuator：使用Spring Boot Actuator来提供产品级别的功能，以便帮助开发人员实现应用的监控和管理。

3. 技术型的Starter

    Spring Boot还包括一些技术型的Starter，如果要排除或替换特定的技术，可以使用它们。

    * spring-boot-starter-jetty：使用Jetty作为内嵌容器，可以替换spring-boot-starter-tomcat。
    * spring-boot-starter-json：用于处理JSON。
    * spring-boot-starter-log4j2:使用Log4j2来记录日志，可以替换spring-boot-starter-logging。
    * spring-boot-starter-logging：默认采用Logback来记录日志。
    * spring-boot-starter-reactor-netty：使用Reactor Netty来作为内嵌的响应式的HTTP服务器。
    * spring-boot-starter-tomcat：默认使用Tomcat作为默认的内嵌容器。
    * spring-boot-starter-undertow：使用Undertow作为内嵌容器，可以替换spring-boot-starter-tomcat。

#### Spring Boot2新特性

1. Gradle插件

2. 基于最新的Java 8和Spring Framework 5

3. Spring Boot周边技术栈的更新

### 开启第一个Spring Boot项目

#### 环境配置

#### 通过Spring Initializr初始化一个Spring Boot原型

Spring Initializr是用于初始化Spring Boot项目的可视化平台。

访问网站[Spring Initializr](https://start.spring.io/)，该网站是Spring提供的官方Spring Initializr网站。
[Spring Initializr项目源码地址](https://github.com/spring-io/initializr/)

#### 用Gradle编译项目

进入项目根目录，执行gradle build来对项目进行构建。

#### 探索项目

1. build.gradle文件

2. gradlew和gradlew.bat文件

3. build和.gradle目录

4. Gradle Wrapper

5. src目录

#### 如何提升Gradle的构建速度

1. Gradle Wrapper指定本地

    修改Gradle Wrapper配置，将参数“distributionUrl”指向本地文件。

    ```java
    distributionUrl=file\:/path-to-gradle
    ```

2. 使用国内Maven镜像仓库

    Gradle可以使用Maven镜像仓库。使用国内的Maven镜像仓库可以极大地提升依赖包的下载速度。
    使用自定义镜像方法：

    ```java
    repositories {
        // mavenCentral()
        maven { url "https://repo.spring.io/snapshot" }
        maven { url "https://repo.spring.io/milestone" }
        maven { url "http://maven.aliyun.com/nexus/content/groups/public/" }
    }
    ```

### Hello World

#### 编写项目构建信息

#### 编写程序代码

1. 观察Application.java

   ​	源代码：

   ```java
   package com.waylau.spring.cloud.weather;
   
   import org.springframework.boot.SpringApplication;
   import org.springframework.boot.autoconfigure.SpringBootApplication;
   
   /**
   * 主应用程序
   *
   * @since 1.0.0 2017年9月27日
   * @author <a href="https://waylau.com">Way Lau</a>
   */
   @SpringBootApplication
   public class Application {
   
       public static void main(String[] args) {
           SpringApplication.run(Application.class, args);
       }
   }
   ```

   ​	Spring Boot提供了一个方便的\@SpringBootApplication选择，该注解的默认属性，等同于使用@Configuration、@EnableAutoConfiguration和@ComponentScan三个注解组合的默认属性。

2. main方法

3. 编写控制器HelloController


   ​	HelloController.java源代码：

   ```java
   package com.waylau.spring.cloud.weather.controller;
   
   import org.springframework.web.bind.annotation.RequestMapping;
   import org.springframework.web.bind.annotation.RestController;
   
   /**
    * Hello Controller.
    *
    * @since 1.0.0 2017年9月27日
    * @author <a href="https://waylau.com">Way Lau</a>
    */
   @RestController
   public class HelloController {
       
       @ResquestMapping("/hello")
       public String hello() {
           reutrn "Hello World! Welcome to visit waylau.com!";
       }
   }
   ```

   ​	@RestController等价于@Controller与@ResponseBody的组合，主要用于返回在RESTful应用常用的JSON格式数据。

#### 编写测试用例

HelloControllerTest.java源代码：

```java
package com.waylau.spring.cloud.weather.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.hamrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * HelloController Test.
 *
 * @since 1.0.0 2017年9月27日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTest {
    
    @Autowired
    private MockMvc mockMvc;
    
    @Test
    public void testHello() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
                       .andExpect(status().isOk())
                       .andExpect(content().string(equalTo("Hello World! Welcome to visit waylau.com!")));
    }
}
```



#### 运行程序

1. 使用Gradle Wrapper

   执行 gradlew build 命令来对程序进行构建。

2. 运行程序

   执行 java -jar build/libs/hello-world-1.0.0.jar 来运行程序。

3. 访问程序

   在浏览器中访问[测试地址](http://localhost:8080/hello)。

#### 其他运行程序的方式

1. 以“Java Application”运行

2. 使用Spring Boot Gradle Plugin插件运行

   在命令行执行方式如下：

   ```bash
   $ gradle bootRun
   ```

   或者

   ```bash
   $ gradlew bootRun
   ```

### Gradle与Maven的抉择

#### Maven概述

​	Maven不仅内置了依赖管理，更有一个可能拥有全世界最多Java开源软件包的中央仓库，Maven用户无须进行任何配置，就可以直接想用。

1. Maven生命周期

   Maven主要有以下三种内建的生命周期：

   * default：用于处理项目的构建和部署。
   * clean：用于清理Maven产生的文件和文件夹。
   * site：用于处理项目文档的创建。

2. 依赖管理

   依赖管理是Maven的核心功能。Maven为Java世界引入了一个新的依赖管理系统。在Java世界中，可以用groupId、artifactId、version组成Coordination（坐标）唯一标识一个依赖。任何基于Maven构建的项目自身也必须定义这三个属性，生成的包也可以是jar包，也可以是war包或ear包。

   在依赖管理中，另一个重要的概念是scope（范围）。Maven有6种不同的scope。

   * compile：默认就是compile，什么都不配置也就意味着是compile。compile表示被依赖项目需要参与当前项目的编译，当然后续的测试，运行周期也参与其中，是一个比较强的依赖。打包的时候通常能够需要包含进去。
   * test：此类依赖项目仅仅参与测试相关的工作，包括测试代码的编译和执行。一般在运行时不需要这种类型的依赖。
   * runtime：表示被依赖项目无须参与项目的编译，不过后期的测试和运行周期需要参与。一个典型的例子是logback。
   * provided：该类依赖只参与编译和运行，但并不需要在发布时打包进发布包。一个典型的例子是servlet-api。
   * system：从参与度来说，与provided相同，不过被依赖不会从Maven仓库获取，而是从本地文件系统获取，所以一定需要匹配systemPath属性使用。
   * import：这仅用与依赖关系管理部分中pom类型的依赖。它表示指定的pom应该被替换为该pom的dependencyManagement部分中的依赖关系。这是为了集中大多模型项目的依赖关系。

3. 多模块构建

   Maven支持多模块构建。在现代项目中，京城需要将一个大象软件产品划分为多个模块来进行开发，从而实现软件项目的“高内聚，低耦合”。

   Maven的多模块构建通过一个名为项目继承（Project Inheritance）的功能来实现的。Maven允许将一些需要继承的元素，在父pom文件中进行指定。

#### Gradle概述

​	Gradle是一个基于Ant和Maven概念的项目自动化构建工具。与Ant和Maven最大的不同之处在于，它使用一种基于Groovy的特定领域语言（DSL）来声明项目配置，抛弃了传统的基于XML的各种烦琐配置。

1. Gradle生命周期

   Gradle是基于编程语言的，可以自己定义任务（task）和任务之间的依赖，Gradle会确保有顺序地去执行这些任务及依赖任务，并且每个任务只执行一次。当任务执行时，Gradle要完成任务和任务之间的定向非循环图（Directed Acyclic Graph）。

   Gradle供偶见主要有三个不同的阶段：

   * 初级阶段（Initialization）：Gradle支持单个和多个项目的构建。Gradle在初始化阶段决定哪些项目（project）参与构建，并且为每个项目创建一个Project类的实例对象。
   * 配置阶段（Configuration）：在这个阶段配置诶个Project的实例对象，然后执行这些项目脚本中的一部分任务。
   * 执行阶段（Execution）：Gradle确定任务的子集，在配置界面创建和配置这些任务，然后执行任务。这些子集任务的名称当成参数传递给gradle命令和当前目录。接着，Gradle执行每一个选择的任务。

2. 依赖管理

   通常，一个项目的依赖会包含子集的依赖。当Gradle运行项目的测试，它需要找到这些依赖关系，使它们存在项目中。

   Gradle借鉴了Maven里面依赖管理很多的优点，甚至可以重用Maven中央库。

3. 多项目构建

   Gradle天然地支持多项目构建。
   
   存在两个Web应用程序的子项目：date和hello。
   
   settings.gradle文件内容：
   
   ```groovy
   include 'date', 'hello'
   ```
   
   build.gradle 文件内容：
   
   ```groovy
   allprojects {
       plugins {
   		id 'java'
   	}
   
   	group = 'org.gradle.sample'
   	version = '1.0.0'
   	sourceCompatibility = '1.8'
   }
   subprojects {
       plugins {
           id 'war'
       }
       repositories {
   		mavenCentral()
   	}
   	dependencies {
   		implementation 'javax.servlet:servlet-api:2.5'
   	}
   }
   task explodedDist(type: Copy) {
       into "$buildDir/explodedDist"
       subprojects {
           from tasks.withType(war)
       }
   }
   ```
   
   

#### Gradle与Maven的对比

1. 一致的项目结构
2. 一致的仓库
3. 支持大型软件的构建
4. 丰富的插件机制
5. Groovy而非XML
6. 性能比对

## Spring Boot的高级主题

### 构建RESTful服务

#### RESTful服务概述

RESTful服务（也称为REST Web服务，RESTful Web Services）是松耦合的，这特别适合用于为客户创建在互联网传播的轻量级Web服务API。在RESTful服务中，我们经常会将资源以JSON或XML等轻量级的数据格式进行暴露，从而可以方便地让其他REST客户端进行调用。

1. 基于JAX-RS的RESTful服务

   在Java EE规范中，针对构建RESTful服务，主要是JAX-RS（Java API for RESTful Web Services），该规范使Java程序员使用一套固定的接口来开发REST应用，避免了依赖第三方框架。同时，JAX-RS使用POJO编程模型和基于标注的配置，并集成了JAXB，从而可以有效缩短REST应用的开发周期。

2. 基于Spring MVC的RESTful服务

   Spring MVC框架本省也是可以实现RESTful服务的，只是并未实现JAX-RS规范。在Spring Boot应用中，通常采用Spring MVC来实现RESTful服务。

   Spring MVC对于RESTful的支持，主要通过以下注解来实现：

   * @Controller：声明为请求处理器。
   * @RequestMapping：请求应射到相应的处理方法上。该注解又可以细化为以下几种类型：
     - @GetMapping；
     - @PostMapping；
     - @PutMapping；
     - @DeleteMapping；
     - @PathchMapping；
   * @ResponseBody：响应内容的转换，如转换成JSON格式。
   * @RequestBody：请求内容的转换，如转换成JSON格式。
   * @RestController：等同于@Controller+@ResponseBody，方便处理RESTful的服务请求。

#### 配置环境

采用如下开发环境：

* JDK
* Gradle
* Spring Boot Web Starter

#### 需求分析及API设计

用户管理的整体API设计如下：

* GET/users：获取用户列表；

* POST/users：保存用户；

* GET/users{id}：获取用户信息；

* PUT/users/{id}：修改用户；

* DELETE/users/{id}：删除用户；

相应的控制器定义：

```java
@RestController
@RequestMapping("/users")
public class UserControlelr {
    
    /**
     * 获取用户列表
     *
     * @return
     */
    @GetMapping
    public List<User> getUsers() {
        return null;
    }
    
    /**
     * 获取用户信息
     * @param Id
     * @return
     */
    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") long id) {
        return null;
    }
    
    /**
     * 保存用户
     *
     * @param user
     */
    @PostMapping
    public User createUser(@RequestBody User user) {
        return null;
    }
    
    /**
     * 修改用户
     *
     * @param id
     * @param user
     */
    @PutMapping("/{id}")
    public void updateUser(@PathVariable("id") long id, @RequestBody User user) {
        
    }
    
    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") long id) {
        
    }
}
```



#### 项目配置

#### 编写程序代码

1. 实体类
2. 仓库结构即实现
3. 控制器类

#### 安装REST客户端

#### 运行、测试程序

### Spring Boot的配置详解

#### 理解Spring Boot的自动配置

对于每个pom文件的“spring-boot-starter-\*”依赖，Spring Boot会执行默认的AutoConfiguration类。

AutoConfiguration类使用\*AutoConfiguration词法模式，其中\*代表类库。例如，JPA存储哭得自动配置是通过JpaRespositoriesAutoConfiguration来实现的。

使用--debug运行应用程序可以查看自动配置的相关报告。

#### 重写默认的配置值

重写的配置值配置在application.properties文件中即可。

#### 更换配置文件的位置

默认情况下，Spring Boot将所有配置外部化到application.properties文件中。但是，它仍然是应用程序构建的一部分。

此外，可以通过设置来实现从外部读取属性。以下是设置的属性：

* spring.config.name：配置文件名；
* spring.config.location：配置文件的位置；

#### 自定义配置

开发者可以将自定义属性添加到application.properties文件中。

例子：

将一个名为“file.server.url”的属性添加到application.properties文件中。在Spring Boot启动后，我们就能将该属性自动注入到应用中。

源代码：

```java
@Controller
@RequestMapping("/u")
public class UserspaceController {
    @Value("${file.server.url}")
    private String fileServerUrl;
    
    @GetMapping("/{username}/blogs/edit")
    public ModelAndView createBlog(@PathVariable("username") String username, Model model) {
        model.addAttribute("blog", new Blog(null, null, null));
        model.addAttribute("fileServerUrl", fileServerUrl);
        return new ModelAndView("/userspace/blogedit", "blogModel", model);
    }
}
```

@Value注解加载属性值的时候支持两种表达式来进行配置，如下所示：

* 一种是上面介绍的PlaceHolder方式，格式为${...}，大括号内为PlaceHolder。
* 另一种是使用SpEL表达式（Spring Express Language），格式为#{...}，大括号内为SpEL表达式。

#### 使用.yaml作为配置文件

YAML与平面属性文件相比，提供了类似JSON的结构化配置。YAML数据结构可以用类似大纲的缩排方式呈现，结构通过缩进来表示，连续的项目通过减号“-”来表示，map结构里面的key/value对用冒号“:”来分隔。

示例：

```yaml
spring:
	application:
		name: waylau
	datasource:
		driverClassName: com.mysql.cj.jdbc.Driver
		url: jdbc:mysql://localhost:3306/test
	server:
		port: 8081
```

#### profiles的支持

Spring Boot支持profiles，即不同的环境使用不同的配置。通常需要设置一个系统属性（spring.profiles.active）或者OS环境变量（SPRING_PROFILES_ACTIVE）。

YAML文件实际上是由“---”行分隔的文档序列，每个文档分别解析为平坦化的映射。

如果一个YAML文档包含一个spring.profiles键，那么配置文件的值（逗号分隔的配置文件列表）将被反馈到Spring Environment.acceptsProfiles()中，并且如果这些配置文件中的任何一个被激活，那么文档包含在最终的合并中。

示例：

```yaml
server:
	port: 9000
---
spring:
	profiles: development
server:
	port: 9001
---
spring:
	profiles: production
server:
	port: 0
```

### 内嵌Servlet容器

Spring Boot Web Starter内嵌了Tomcat服务器。在应用中使用嵌入式的Servlet容器，可以方便我们来进行项目的启动和调试。

Spring Boot支持包括嵌入式Tomcat、Jetty和Undertow服务器。默认情况下，嵌入式服务将侦听端口8080上的HTTP请求。

#### 注册Servlet、过滤器和监听器

当使用嵌入式Servlet容器时，可以通过使用Spring bean或扫描Servlet组件从Servlet规范（如HttpSessionListener）中注册Servlet、过滤器和所有监听器。

默认情况下，如果上下文只包含一个Servlet，它将映射到“/”路径。在多个Servlet bean的情况下，bean名称将被用作路径前缀，过滤器将映射到“/*”路径。

#### Servlet上下文初始化

如果需要在Spring Boot应用程序中执行Servlet上下文初始化，则应注册一个实现org.springframework.boot.web.servlet.ServletContextInitializer接口的bean。onStartup方法提供对ServletContext的访问，并且如果需要，可以轻松地用作现有WebApplicationInitializer的适配器。

当使用嵌入式容器时，可以使用@ServletComponentScan来自动注入启用了@WebServlet、@WebFilter和@WebListener注解的类。

#### ServletWebServerApplicationContext

Spring Boot使用一种新型的ApplicationContext来支持嵌入式的Servlet容器。ServletWebServerApplicationContext就是一种特殊类型的WebApplicationContext，它通过搜索单个ServletWebServerFactory bean来引导自身。通常，TomcatServletWebServerFactory、JettyServletWebServerFactory或UndertowServletWebFactory将被自动配置。

#### 更改内嵌Servlet容器

Spring Boot Web Starter默认使用了Tomcat来作为内嵌的容器。在依赖中加入相应的Servlet容器的Starter，就能实现默认容器的替换。

可以使用Spring Environment属性配置常见的Servlet容器的相应设置。通常在application.properties文件中来定义属性。

常见的Servlet容器设置：

* 网络设置：监听HTTP请求的端口（server.port）、绑定到server.address的接口地址等。
* 会话设置：会话是否持久（server.session.persistence）、会话超时（server.session.timeout）、会话数据的位置（server.session.store-dir）和会话cookie配置（server.session.cookie.*）。
* 错误管理：错误页面的位置（server.error.path）等。
* SSL。
* HTTP压缩。

### 实现安全机制

#### 实现基本认证

如果Spring Security位于类路径上，则所有HTTP断电上默认使用基本认证，这样就能使Web应用程序得到一定的安全保证。最快捷的方式是在依赖中添加Spring Boot Security Starter。

```groovy
dependencies {
    Implementation 'org.springframework.boot:spring-boot-starter-security'
}
```

如果需要向Web应用程序添加方法级别的安全保障，还可以在Spring Boot应用里面添加@EnableGlobalMethodSecurity注解来实现。示例：

```java
@EnableGlobalMethodSecurity
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplicatioon.run(Application.class, args);
    }
}
```



1. @Secured

   此注解是用来定义业务方法的安全配置属性的列表。可以在需要安全角色/权限等的方法上指定@Secured，并且只有那些角色/权限的用户才可以调用该方法。如果不具备要求的角色/权限试图调用此方法，就会抛出AccessDenied异常。

   @Secured不支持Spring EL表达式。

   Spring的@PreAuthorize/@PostAuthorize注解更适合方法级别的安全，也支持Spring EL表达式语言，提供基于表达式的访问控制。

   * @PreAuthorize注解：适合在进入方法前的权限验证，@PreAuthorize可以将登录用户的角色/权限参数传到方法中。
   * @PostAuthorize注解：在方法执行后进行权限验证。

2. 登录帐号和密码

#### 实现OAuth2认证

1. 什么是OAuth2.0

   OAuth2.0的规范可以参卡[RFC 6749](http://tools.ietf.org/html/rtf6749)

   OAuth 是一个开方标准，允许用户让第三方应用访问该用户在某一网站上存储的私密资源（如照片、视频、联系人列表等），而无须将用户和密码提供给第三方应用。

   OAuth允许用户提供一个令牌，而不是用户名和密码来访问它们存放在特定服务提供者的数据。每一个令牌授权一个特定的网站在特定时段内访问特定的资源。

2. OAuth2.0的概念

   OAuth2.0主要有4类角色：

   * resource owner：资源所有者，指终端的“用户”（user）。
   * resource server：资源服务器，即服务提供商存放受保护的资源。访问这些资源，需要获得访问令牌（Access Token）。它与认证服务可以是同一台服务器，可以是不同的服务器。
   * client：客户端，代表向受保护资源进行资源请求的第三方应用程序。
   * authorization server：授权服务器。在验证资源所有者并获得授权成功后，将发放访问令牌给客户端。

3. OAuth2.0的认证流程

   1. 用户打开客户端以后，客户端请求资源所有者（用户）的授权。
   2. 用户同意给予客户端授权。
   3. 客户端使用上一步获取的授权，向服务器申请访问令牌。
   4. 认证服务对客户端进行认证后，确认无误，同意方法访问令牌。
   5. 客户端使用访问令牌，向资源服务器申请获取资源。
   6. 资源服务器确认令牌无误，同意向客户端开方资源。

   用户授权模式：

   * 授权码模式（authorization code）。
   * 简化模式（implicit）。
   * 密码模式（resource owner password credentials）。
   * 客户端模式（client credentials）。

4. 配置

   项目的核心配置：

   ```properties
   github.client.clientId=ad2abbc19b6c5f0ed117
   github.client.clientSecret=26db88a4dfc34cebaf196e68761c1294ac4ce265
   github.client.accessTokenUri=https://github.com/login/oauth/access_token
   github.client.userAuthorizationUri=https://github.com/login/oauth/authorize
   github.client.clientAuthenticationScheme=form
   github.client.tokenName=oauth_token
   github.client.authenticationScheme=query
   github.client.userInfoUri=https://api.github.com/user
   ```

   

5. 项目安全的配置

   安全配置中需要加上@EnbaleWebSecurity、@EnableOAuth2Client注解，来启用Web安全认证机制，并表明这是一个OAuth 2.0客户端。

   示例代码：

   ```java
   @EnableWebSecurity
   @EnableOAuth2Client	// 启用OAuth2.0客户端
   @EnbaleGlobalMethodSecurity(prePostEnabled = true) // 启用方法安全设置
   public class SecurityConfig extends WebSecurityConfigurerAdapter {
       // ...
       
       protected void configure(HttpSecurity http) throws Exception {
           http.addFilterBefore(ssoFilter(), BasicAuthenticationFilter.class)
               .andMatcher("/**")
               .authorizeRequests()
               .antMatchers("/", "/index", "/403", "/css/**", "/js/**", "/fonts/**").permitAll() // 不设限制，都允许访问
               .anyRequest()
               .authenticated()
               .and().logout().logoutSuccessUrl("/").permitAll()
               .and().csrf().csrfTokenRespository(CookieCsrfTokenRespository.withHttpOnleFalse());
       }
       
       private Filter ssoFilter() {
           OAuth2ClientAuthenticationProcessingFilter githubFilter = new OAuth2ClientAuthenticationProcessingFilter("/login");
           OAuth2RestTemplate githubTemplate = new OAuth2RestTemplate(github(), oauth2ClientContext);
           githubFilter.setRestTemplate(githubTemplate);
           UserInfoTokenServices tokenServices = new UserInfoTokenServices(githubResource().getUserInfoUri(), github.getClientId());
           tokenServices.setRestTemplate(githubTemplate);
           githubFilter.setTokenServices(tokenServices);
           return githubFilter;
       }
       
       @Bean
       public FilterRegistrationBean ouath2ClientFilterRegistration(OAuth2ClientContextFilter filter) {
           FilterRegistrationBean registration = new FilterRegistrationBean();
           registration.setFilter(filter);
           registration.setOrder(-100);
           return registration;
       }
       
       @Bean
       @ConfigurationProperties("github.resource")
       public ResourceServerProperties githubResource() {
           return new ResourceServerProperties();
       }
   }
   ```

   

6. 资源服务器

   MainController.java 示例代码：

   ```java
   @Controller
   public class MainController {
       
       @GetMapping("/")
       public String root() {
           return "redirect:/index";
       }
       
       @GetMapping("/index")
       public String index(Principal principal, Model model) {
           if (principal == null) {
               return "index";
           }
           System.out.println(principal.toString());
           model.addAttribute("principal", principal);
           return "index";
       }
       
       @GetMapping("/403")
       public String accessDenied() {
           return "403";
       }
   }
   ```

   UserController.java 示例代码：

   ```java
   @RestController
   @RequestMapping("/")
   public class UserController {
       /**
        * 查询所有用户
        * @return
        */
       @GetMapping("/users")
       @PreAuthorize("hasAuthority('ROLE_USER')")	// 指定角色权限才能操作方法
       public ModelAndView List(Model model) {
           List<User> list = new ArrayList<>();	// 当前所在页面数据列表
           list.add(new User("waylau", 29));
           list.add(new User("老卫", 30));
           model.addAttribute("title", "用户管理");
           model.addAttribute("userList", list);
           return new ModelAndView("users/list", "userModel", model);
       }
   }
   ```

   

7. 前端页面

   首页主要采用Thymeleaf及Bootstrap来编写的。

   首页示例代码：

   ```html
   <body>
       <div class="container">
           <div class="mt-3">
               <h2>
                   Hello Spring Security
               </h2>
           </div>
           <div sec:authorize="isAuthenticated()" th:if="${pricipal}" th:object="${pricipal}">
               <p>
                   已有用户登录
               </p>
               <p>
                   登录的用户为：<span sec:authentication="name"></span>
               </p>
               <p>
                   用户授权为：<span th:text="*{userAuthentication.authorities}"></span>
               </p>
               <p>
                 用户头像为：<img alt="" class="avatar width-full rounded-2" height="230" th:src="*{userAuthentication.details.avatar_url}">  
               </p>
           </div>
           <div sec:authorize="isAnonymous()">
               <p>
                   未有用户登录
               </p>
           </div>
       </div>
   </body>
   ```

   用户管理界面示例代码：

   ```html
   <body>
       <div class="container">
           <div class="mt-3">
               <h2 th:text="${userModel.title}">
                   Welcome to waylau.com
               </h2>
           </div>
           <table class="table table-hover">
               <thead>
                   <tr>
                   	<td>Age</td>
                   	<td>Name</td>
                       <td sce:authorize="hasRole('ADMIN')">Operation</td>
                   </tr>
               </thead>
               <tbody>
                   <tr th:if="${userModel.userList.size} eq 0">
                       <td colspan="3">没有用户信息！！</td>
                   </tr>
   				<tr th:each="user : ${userModel.userList}">
                       <td th:text="${user.age}">11</td>
                       <td th:text="${user.name}">waylau</td>
                       <td sec:authorize="hasRole('ADMIN')">
                           <div>
                               我是管理员
                           </div>
                       </td>
                   </tr>
               </tbody>
           </table>
       </div>
   </body>
   ```

   

8. 运行效果

9. 注册GitHub应用

### 允许跨域访问

#### 什么是跨域访问

#### 如何识别是跨域访问

#### 在Spring Boot应用中允许跨域访问

1. 方法级别的跨域访问
2. 全局跨域访问

### 消息通信

消息通道是企业信息集成中非常重要的一种方式。消息的通信一般是由消息队列系统（Message Queuing System，MQ）或面向消息中间件（Message oriented Middleware，MOM）来提供高效可靠的消息传递机制进行平台无关的数据交流，并可基于数据通信进行分布式系统的集成。通过提供消息传递和消息排队模型，可在分布式环境下扩展进程间的通信，并支持多种通信协议、语言、应用程序、硬件和软件平台。

#### 消息通信的好处

通过使用MQ或MOM，通信双方的程序（称其为消息客户程序）可以在不同的时间运行，程序不在网络上直接通话，而是间接地将消息放入MQ或MOM服务器的消息队列中。因为程序间没有直接的联系，所以它们不必同时运行；消息放入适当的队列时，目标程序不需要正在运行；即使目标程序在运行，也不意味着要立即处理该消息。

消息客户程序之间通过将消息放入消息队列或从消息队列中提取消息来进行通信。客户程序不直接与其他程序通信，避免了网络通信的复杂性。消息队列和网络通信的维护工作由MQ或MOM完成。

#### 使用Java Message Service

Java Message Service（JMS）API是一个Java面向消息中间件的API，用于两个或多个客户端之间发送消息。

JMS目标包括：

* 包含实现负责企业应用所需要的功能特性；

* 定义了企业消息概念和功能的一组通用集合；

* 最小化企业消息产品的概念，以降低学习成本；

* 最大化消息应用的可移植性；

JMS支持企业消息产品提供的消息风格：

* 点对点（Point-to-Point，PTP）消息风格：允许一个客户端通过一个角“队列（queue）”的中间抽象发送一个消息给另一个客户端。发送消息的客户端将一个消息发送到指定的队列中，接收消息的客户端从这个队列中抽取消息。
* 发布订阅（Publish/Subscribe，Pub/Sub）消息风格：允许一个客户端通过一个叫“主题（topic）”的中间抽象发送一个消息给多个客户端。发送消息的客户端将一个消息发布到指定的主题中，然后这个消息被投递 到所有订阅这个主图的客户端。

1. 使用JNDI ConnectionFactory

   应用程序中，Spring Boot将尝试使用JNDI找到JMS ConnectionFactory。默认情况下，将检查位置java:/JmsXA和java:/XAConnectionFactory。如果需要指定其他位置，可以使用spring.jms.jndi-name属性。

   ```properties
   spring.jsm.jndi-name=java:/MyConnectionFactory
   ```

   

2. 发送消息

   Spring的JmsTemaple是自动配置的，可以将其直接装配到自己的bean中。

   ```java
   import org.springframework.beans.factory.annotation.Autowired;
   import org.springframework.jsm.core.JmsTemplate;
   import org.springframework.stereotype.Componenet;
   
   @Component
   public class MyBean {
       
       private final JmsTemplate jmsTempleate;
       
       @Autowired
       public MyBean(JmsTemplate jmsTemplate) {
           this.jmsTemplate = jmsTemplate;
       }
   }
   ```

   

3. 接收消息

   在JMS架构中，可以使用@JmsListener来注解任何bean，以创建侦听器端点。如果没有定义JmsListeneerContainerFactory，则会自动配置默认值。如果定义了 DestinationResolver或MessageConverter bean，则它们将会自动关联到默认工厂。

   默认工厂是事务性的。如果在JtaTransactionManager存在的基础架构中运行，则默认情况下将与侦听器容器相关联。如果没有，sessionTransacted标识将被启用。在后一种情况下，可以通过在侦听器方法（或其代理）上添加@Transactional来将本地数据存储事务关联到传入消息的处理。这将确保在本地事务完成后确认传入的消息。这还包括发送在同一个JMS会话上执行的响应消息。

#### 使用RabbitMQ

RabbitMQ是更高级别的消息中间件，实现了Advanced Message Queuing Protocol（AMQP）协议。Spring AMQP项目将核心Spring概念应用于基于AMQP的消息传递解决方案的开发。

1. 配置RabbitMQ

   RabbitMQ的配置由外部配置属性spring.rabbitmq.*来控制。

2. 发送消息

   Spring的AmqpTemplate和AmqpAdmin是自动配置的，可以将它们直接自动装配到自己的bean中。

3. 接收消息

   当Rabbit的基础架构存在时，可以使用@RabbitListener来注解bean，以创建侦听器端点。如果没有RabbitListenerContainerFactory，则会自动配置默认的SimpleRabbitListenerContainerFactory，可以使用spring.rabbitmq.listener.type属性切换到直接容器。如果MessageConverter或MessageRecover bean被定义，它们将自动关联到默认工厂。

### 数据持久化

JPA（Java Persistence API）是用于管理Java EE和Java SE环境中的持久化，以及对象/关系映射的Java API。

#### JPA的产生背景

ORM（Object Relation Mapping，对象关系映射）是一种用于实现面向对象编程语言里不同类型系统的数据之间转换的程序技术。

ORM框架的出现，使直接存储对象称为可能，它们将对象拆分成SQL语句，从而来操作数据库。但是不同的ORM框架，在使用上存在比较大的差异，这也导致开发人员需要学习各种不同的ORM框架，增加了技术学习的成本。

而JPA规范就是为了解决这个问题：规范ORM框架，使用ORM框架统一的接口和用法。这样在采用面向接口编程的技术中，即便更换了不同的ORM框架，也无须变更业务逻辑。

#### Spring Data JPA概述

Spring Data JPA含有以下特征：

* 基于Spring和JPA来构建负责的存储库。
* 支持[Querydsl](http://www.querydsl.com)谓词，因此支持类型安全的JPA查询。
* 域类的透明审计。
* 具备分页支持、动态查询执行、集成自定义数据访问代码的能力。
* 在引导时验证带@Query注解的查询。
* 支持基于XML的实体映射。
* 通过引入@EnableJpaRepositories来实现基于JavaConfig的存储库配置。

#### 如何使用Spring Data JPA

在项目中使用spring-data-jpa的推荐方法是使用依赖关系管理系统。

使用Gradle构建的示例：

```groovy
dependencies {
    Implementation 'org.springframework.data:spring-data-jpa'
}
```

在代码中需要声明继承Spring Data JPA中的接口：

```java
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    public List<User> findByNameLike(String name);
}
```



#### Spring Data JPA的核心概念

Spring Data存储库抽象中的中央接口是Repository。它将域类及域类的ID类型作为类型参数进行管理。此接口主要作为标记接口捕获要使用的类型，并帮助发现扩展此接口。

接口定义：

```java
public interface CurdRepository<T, ID extends Serialize> extends Repository<T, ID> {
    <S extends T> S save(S entity);
    T findOne(ID primaryKey);
    Iterable<T> findAll();
    Long count();
    void delete(T entity);
    boolean exists(ID primaryKey);
}
```

#### Spring Data JPA的查询方法

对于底层数据存储的管理，通常使用变准CRUD功能的资源库来实现。使用Spring Data声明这些查询将会变得更简单。只需执行以下步骤：

1. 声明扩展Repository或器子接口之一的接口

   声明接口，并输入将要处理的域类型和ID类型。

   ```java
   interface PersonRepository extends Repository<Person, Long> {...}
   ```

   

2. 在声明上声明查询方法

   ```java
   interface PersonRepository extends Repository<Person, Long> {
       List<Person> findByLastname(String lastname);
   }
   ```

   

3. 为这些接口创建代理实例

   可以通过JavaConfig的方式：

   ```java
   interface PersonRepository extends Repository<Person, Long> {
       List<Person> findByLastname(String lastname);
   }
   ```

   或通过XML配置方式：

   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <beans xmlns="http://www.springframework.org/schema/beans"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="http://www.springframework.org/schema/beans
                              http://www.springframework.org/schema/beans/spring-beans.xsd
                              http://www.springframework.org/schema/data/jpa
                              http://www.springframework.org/schema/data/spring-jpa.xsd">
       <jpa:repositories base-package="com.waylau.repositories"/>
   </beans>
   ```

   JavaConfig变量不会明确配置包，因为默认情况下使用注解类的包。如果要自定义扫描的程序包，要使用数据存储特定存储库的@Enable注解。

4. 获取注入的存储实例并使用它

   ```java
   public class SomeClient {
       @Autowired
       private PersonRepository repository;
       public void doSomething() {
           List<Person> persons = repository.findByLastname("Lau");
       }
   }
   ```

   

### 实现热插拔

#### 重新加载静态内容

支持热加载的方式推荐使用spring-boot-devtools，因为它提供了额外的功能，例如，支持快速应用程序重启和LiveReload及智能的开发配置（如模板缓存）。

Maven添加Devtools的方式：

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-devtools</artifactId>
        <optional>true</optional>
    </dependency>
</dependencies>
```

Gradle添加Devtools的方式：

```groovy
dependencies {
    Implementation 'org.springframework.boot:spring-boot-devtools'
}
```

如果不想在应用程序运行时启动LiveReload服务器，则可以将spring.devtools.livereload.enabled属性设置为false。

#### 重新加载模板

Spring Boot大多数模板技术中，都有包括禁用缓存的配置选项。启用禁用缓存的选项后，修改模板文件后，就能自动实现模板的加载。如果使用spring-boot-devtools模块，这些属性将在开发时自动配置。

常用模板的禁用缓存设置：

1. Thymeleaf：spring.thymeleaf.cache=false
2. FreeMarker：spring.freemarker.cache=false
3. Groovy：spring.groovy.cache=false

#### 应用程序快速重启

#### 重新加载Java类而不重现启动容器

## 微服务的测试

### 测试概述

#### 传统的测试所面临的问题

1. 开发测试对立
2. 事后测试
3. 测试方法老旧
4. 技术发生巨大的变革
5. 测试工作被低估
6. 发布缓慢

#### 如何破解测试面临的问题

1. 开发与测试组合
2. 测试角色的转变
3. 积极发布，即使得到反馈
4. 增大自动化测试的比例
5. 合理安排测试的介入时机

### 测试的类型和范围

#### 测试类型

1. 单元测试

   单元测试是在软件开发过程中要进行的最低级别的测试活动，软件的独立单元将在与程序的其他的部分相隔离的情况下进行测试。

   单元测试的范围局限在服务内部，它是围绕着一组相关联的案例编写的。

   单元测试用例往往由编写模块的开发人员来编写。

2. 集成测试

   集成测试主要用于测试各个模块能够正确交互，并测试其作为子系统的交互性，以查看接口是否存在缺陷。

   集成测试的目的在于，通过集成模块检查路径畅通与否，来确认模块与外部组件的交互情况。集成测试可以结合CI（持续集成）的实践，来快速找到外部组件间的逻辑回归与断裂，从而有助于评估各个单独模块中所含逻辑的正确性。

   集成测试按照不同的项目类型，有时也细分为组件测试、契约测试。

3. 系统测试

   系统测试用于测试集成系统运行的完整性。

   该测试可能会涉及外部依赖资源，如数据库、文件系统、网络服务等。

#### 测试范围及比例

1. 测试范围

   对于测试的类型和范围，一般按照规模化分为小型测试、中型测试、大型测试，也就是平常理解的单元测试、集成测试、系统测试。

   * 小型测试
   * 中型测试
   * 大型测试

2. 测试比例

### 如何进行微服务的测试

#### 微服务的单元测试

1. 为什么需要重构代码

   “重构（Refactoring）”一词最早起源于Martin Flower的《重构：改善既有代码的涉及》一书。

   所谓重构，简而言之，就是在不改变代码外部行为的前提下，对代码进行修改，以改善程序的内部结构。

   重构的前提是代码的行为是正确的，也就是说，关于代码功能以及经过测试，并且测试通过了，这是重构的前提。

   软件需要重构的原因：

   * 软件不一定一开始就是正确的。
   * 随着实践推移，软件的行为变得难以理解。
   * 能运行的代码，并不一定是好代码。

   重构的目的：

   * 消除重复。
   * 使代码易理解、以修改。
   * 改进软件的设计。
   * 查找Bug，提高质量。
   * 提高编码效率和编码水平。

2. 何时应该进行重构

   * 随时重构。也就是说，将重构当作是开发的一种习惯，重构应该与测试一样自然。
   * 事不过三，三则重构。
   * 添加新功能时。
   * 修改错误时。
   * 代码审查。

3. 代码的“坏味道”

   * DuplicatedCode（重复代码）：重复是万恶之源。
   * LongMethod（过长函数）：过长函数会导致则人不明确、难以切割、难以理解等一系列问题。
   * LargeClass（过大的类）：会导致职责不明确、难以理解。
   * LongParameterList（过长参数列）：过长参数列其实是没有真正地遵循面向对象的编码方式，对程序员来说也是难以理解的。
   * DivergentChang（发散式变化）：当对多个需求进行修改时，都会动到这种类。解决方法是对代码进行拆分，将总是一起变化的东西放在一起。
   * ShotgunSurgery（霰弹式修改）：其实就是再没有封装变化处改动一个需求，然后会涉及到多个类被修改。解决方法是将各个修改点集中起来，抽象成一个新类。
   * FeatureEnvy（依恋情节）：一个类对其他类存在过多的依赖。解决方法是该类并到所依赖的类里面。
   * DataClumps（数据泥团）：数据泥团是常一起的大堆数据。如果数据是有意义的，解决方法是将结构数据转变为对象。
   * PrimitiveObsession（基本类型偏执）：热衷与使用int、long、String等基本类型。其解决方法是将其修改成使用类代替。
   * SwitchStatements（switch惊悚现身）：当出现switch语句判断的条件太多时，则要考虑少用switch语句，采用多态来代替。
   * ParalleInheritanceHierarchies（平行继承体系）：过多平行的类，使用类继承并联起来。解决方法是将其中一个类去掉继承关系。
   * LazyClass（冗赘类）：针对这些冗赘类，其解决方法是把这些不再重要的类里面的逻辑合并到相关类，并删除旧类。
   * SpeculativeGenerality（夸夸其谈未来性）：对于这些没有用处的类，直接删除即可。
   * TemporaryField（令人迷惑的暂时字段）：对于这些字段，解决方法是将这些临时变量集中到一个新类中管理。
   * MessageChains（过度耦合的消息链）：使用真正需要的函数和对象，而不要依赖消息链。
   * MiddleMan（中间人）：存在这种过度代理的问题，其解决方法是用继承替代委托。
   * InappropriateIntimacy（狎昵关系）：两个类彼此使用对象的private值域。解决方法是划清界限，拆散或合并，或改成单向联系。
   * AlternativeClasseswithDifferentInterfaces（异曲同工的类）：这些类往往是相似的类，却有不同的接口。解决方法是对这些类进行重合、移动函数或抽象子类重复使用的类，从而合并成一个类。
   * IncompleteLibraryClass（不完美的库类）：解决方法是包一层函数或包新的类。
   * DataClass（纯稚的数据类）：这些类很简单，往往仅有公共成员变量或简单的操作函数。解决方法是将相关操作封装进去，减少public成员变量。
   * RefusedBequest（拒绝遗赠）：这些类的表现是父类里面方法很多，但子类只用到有限几个。解决方法是使用代理来替代继承过多。
   * Comments（过多的注释）：注释多了，就说明代码不清不楚了。解决方法是写注释前先重构，去掉多余的注释，“好代码会说话”。

4. 减少测试的依赖

5. mock与stub的区别

   mock和stub都是为了替换外部依赖对象，两者存在以下区别：

   * 前者称为mockist TDD，而后者一般称为classic TDD。
   * 前者是基于行为的验证（Behavior Verification），后者是基于状态的验证（State Verification）。
   * 前者使用的是模拟的对象，而后者使用的是真实的对象。

#### 微服务的集成测试

1. 服务接口

   在微服务的架构中，服务接口大多以RESTful API的形式加以暴露。REST是面向资源的，使用HTTP协议来完成相关通信，其主要的数据交换格式为JSON，当然也可以是XML、HTML、二进制文件等多媒体类型。资源的操作包括获取、创建、修改和删除资源，它们都可以用HTTP协议的GET、POST、PUT和DELETE方法来映射相关的操作。

2. 客户端

   有非常多的客户端可以用于测试RESTful服务。可以直接通过浏览器来进行测试，也可以使用RESTClient、postman等。

#### 微服务的系统测试

1. 冒烟测试

   所谓的冒烟测试，是指对一个新编译的软件版本在需要进行正是测试前，为了确认软件基本功能是否正常而进行的测试。软件经过冒烟测试之后，才会进行后续的正是测试工作。冒烟测试的执行者往往是版本编译人员。

   由于冒烟测试耗时短，并且能够验证软件大部分主要的功能，因此在进行CI/CD每日构建过程中，都会执行冒烟测试。

2. 蓝绿部署

   蓝绿测试通过部署新旧两套版版本降低新版本的风险。其原理是，当部署新版本后（绿部署），老版本（蓝部署）仍然需要保持在生产环境中可用一段时间。如果新版本上线，测试没有问题后，那么所有的生产负荷就会从旧版本切换到新版本中。

   注意事项：

   * 蓝绿两个部署环境是一致的，并且两者应该是完全隔离的（可以是不同的主机或不同的容器）。
   * 蓝绿环境两者之间有一个类似于切换器的装置用于流量的切换，如可以是负载均衡器、反向代理或路由器。
   * 新版本（绿部署）测试失败后，可以马上回溯到旧版本。
   * 蓝部署京城与冒烟测试结合使用。

3. A/B测试

   A/B测试是一种新兴的软件测试方法。A/B测试本质上是将软件分成A、B两个不同的版本来进行分离实验。A/B测试的目的在于通过科学的实验设计、采样样本、流量分割与小流量测试等方式来获得具有代表性的实验结论，并确保该结论在推广到全部流量之前是可信赖的。

4. 金丝雀发布

   金丝雀发布是增量发布的一种类型，它的执行方式是原有软件生产版本可用的情况下，同时部署一个新的版本。这样，部分生产流量就会流到新部署的版本，从而来验证系统是否按照预期的内容执行。这些预期的内容可以是功能性的需求，也可以是非功能性的需求。

   如果新版本没有达到预期的效果，那么可以迅速回溯到旧版本上去。如果达到了预期的效果，那么可以将生产流量更多地流到新版本上去。

## 微服务的协调者——Spring Cloud

### Spring Cloud简介

#### 什么是Spring Cloud

Spring Cloud基于Spring Boot来进行构建服务，并可以轻松地集成第三方类库，来增强应用程序的行为。

[Spring Cloud的项目主页](https://spring.io/projects/spring-cloud)

#### Spring Cloud与Spring Boot的关系

Spring Boot是构建Spring Cloud架构的基石，是一种快速启动项目的方式。

Spring Cloud十一个拥有诸多子项目的大型综合项目，原则上其子项目也都维护着自己的发布版本号。

### Spring Cloud入门配置

#### Maven配置

```xml
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>2.0.0.M3</version>
</parent>
<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-dependencies</artifactId>
            <version>Finchley.M2</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>
<dependencies>
    <dependency>
        <groupId></groupId>
        <artifactId>spring-cloud-starter-eureka</artifactId>
        <snapshots>
            <enabled>false</enabled>
        </snapshots>
    </dependency>
</dependencies>
<repositories>
    <repository>
        <id>spring-milestones</id>
        <name>Spring Milestones</name>
        <url>https://repo.spring.io/libs-milestone</url>
        <snapshots>
            <enabled>false</enabled>
        </snapshots>
    </repository>
</repositories>
```



#### Gradle配置

```groovy
plugins {
	id 'org.springframework.boot' version '2.4.2'
	id 'io.spring.dependency-management' version '1.0.11.RELEASE'
	id 'java'
}

group = 'xyz.junral.spring.cloud'
version = '1.0.0'
sourceCompatibility = '1.8'

repositories {
	mavenCentral()
}

dependencies {
	implementation 'org.springframework.boot:spring-boot-starter-web'
    implementation 'org.springframework.cloud:spring-cloud-starter-netflix-eureka-client'
    testImplementation 'org.springframework.boot:spring-boot-starter-test'
}
```



#### 声明方法

Spring Cloud声明为一个Netflix Eureka Client最简单的应用示例：

```java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Application {
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class. args);
    }
}
```



### Spring Cloud的子项目介绍

#### Spring Cloud子项目组成

Spring Cloud由以下子项目组成：

* Spring Cloud Config：配置中心——利用git来集中管理程序的配置。[项目地址](https://cloud.spring.io/spring-config)
* Spring Cloud Netflix：集成众多Netflix的开源软件，包括Eureka、Hystrix、Zuul、Archaius等。[项目地址](https://cloud.spring.io/spring-cloud-netflix)
* Spring Cloud Bus：消息总线——利用分布式消息将服务和服务实例连接在一起，用于在一个集中传播状态的变化，比如配置更改的事件。可与Spring Cloud Config联合实现热部署。[项目地址](https://cloud.spring.io/spring-cloud-bus)
* Spring Cloud for Cloud Foundry：利用Pivotal Cloudfoundry集成你的应用程序。CloudFoundry是VMware推出的PaaS云平台。[项目地址](https://cloud.spring.io/spring-cloud-cloudfoundry)
* Spring Cloud Cloud Foundry Service Broker：为建立管理云脱管服务的服务代理提供了一个起点。[项目地址](https://cloud.spring.io/spring-cloud-cloudfoundry-service-broker)
* Spring Cloud Cluster：基于 Zookeeper、Redis、Hazelcast、Consul实现的领导选择与平民状态模式的抽象实现。[项目地址](https://cloud.spring.io/spring-cloud)
* Spring Cloud Consul：基于Hashicorp Consul实现的服务发现和配置管理。[项目地址](https://cloud.spring.io/spring-cloud-consul)
* Spring Cloud Security：在Zuul代理中为OAuth2 REST客户端和认证头转发提供负载均衡。[项目地址](https://cloud.spring.io/spring-cloud-security)
* Spring Cloud Sleuth：适用于Spring Cloud应用程序的分布式跟踪，与Zipkin、HTrace和基于日志（如ELK）的跟踪相兼容。可以用于日志的收集。[项目地址](https://cloud.spring.io/spring-cloud-sleuth)
* Spring Cloud Data Flow：一种针对现代运行时可组合的微服务应用程序的云本地编排服务。易于使用的DSL、拖放式GUI和REST  API一起简化了基于微服务的数据管道的整体编排。[项目地址](https://cloud.spring.io/spring-cloud-dataflow)
* Spring Cloud Stream：一个轻量级的事件驱动的微服务框架来快速构建可以连接到外部系统的应用程序。使用Apache Kafka或RabbitMQ在Spring Boot应用程序之间发送和接收消息的简单声明模式。[项目地址](https://cloud.spring.io/spring-cloud-stream)
* Spring Cloud Stream App Starters：基于Spring Boot为外部系统提供Spring的集成。[项目地址](https://cloud.spring.io/spring-cloud-stream-app-starters)
* Spring Cloud Task：短生命周期的微服务——为Spring Boot应用简单声明添加功能和非功能特性。[项目地址](https://cloud.spring.io/spring-cloud-task)
* Spring Cloud Task App Starters：Spring Cloud Task App Starters是Spring Boot应用程序，可能是任何进程，包括Spring Batch作业，并可以在数据处理有限的时间终止。[项目地址](https://cloud.spring.io/spring-cloud-task-app-starters)
* Spring Cloud Zookeeper：基于Apache Zookeeper的服务发现和配置管理的工具包，用于使用zookeeper方式的服务注册和发现。[项目地址](https://cloud.spring.io/spring-cloud-zookeeper)
* Spring Cloud for Amazon Web Services：与Amazon Web Services轻松集成。它提供了一种方便的方式来与AWS提供的服务进行交互，使用众所周知的Spring惯用语和API（如消息传递和缓存API）。开发人员可以围绕脱管服务构建应用程序，而无须关心基础设施或维护工作。[项目地址](https://cloud.spring.io/spring-cloud-aws)
* Spring Cloud Connectors：便于PaaS应用在各种平台上连接云端，如数据库和消息服务。[项目地址](https://cloud.spring.io/spring-cloud-config)
* Spring Cloud Starters：基于Spring Boot项目，用以简化Spring Cloud的依赖管理。该项目已经终止，并且在Angel.SR2后的版本和其他项目合并。[项目地址](https://cloud.spring.io/spring-cloud-connectors)
* Spring Cloud CLI：Spring Cloud CLI插件用于在Groovy中快速创建Spring Cloud组件应用程序。[项目地址](https://cloud.spring.io/spring-cloud/spring-cloud-cli)
* Spring Cloud Contract：Spring Cloud Contract是一个总体项目，其中包含帮助用户成功实施消费者驱动契约（Consumer Driven Contracts）的解决方案。[项目地址](https://cloud.spring.io/spring-cloud-contract)

#### Spring Cloud组件的版本

## 服务拆分与业务建模

### 从一个天气预告系统讲起

#### 开发环境

* JDK
* Gradle
* Spring Boot Web Starter
* Apache HttpClient

#### 数据来源

#### 初始化一个Spring Boot项目

#### 创建天气信息相关的值对象

#### 服务接口及发现

#### 控制器层

#### 配置类

#### 访问API

### 使用Redis提升应用的并发访问能力

#### 为什么需要缓存

采用缓存，一方面可以有效减轻访问接口服务带来的延时问题；另一方面也可以减轻接口的负担，提高并发访问量。

#### 开发环境

* JDK
* Gradle
* Spring Boot Web Starter
* Apache HttpClient
* Spring Boot Data Redis Starter
* Redis

#### 项目配置

添加Spring Boot Data Redis Starter的依赖：

```groovy
dependencies {
    // 添加Spring Boot Data Redis Starter依赖
    compile('org.springframework.boot:spring-boot-starter-data-redis')
}
```



下载、安装并运行Redis

[Linux平台安装参考文档](https://github.com/antirez/redis)

[Windows平台安装包下载地址](https://github.com/MicrosoftArchive/redis/releases)

#### 修改WeatherDataServiceImpl

#### 测试和运行

### 实现天气数据的同步

#### 开发环境

* JDK
* Gradle
* Spring Boot Web Starter
* Apache HttpClient
* Spring Boot Data Redis Starter
* Redis
* Spring Boot Quartz Starter
* Quartz Scheduler

#### 项目配置

添加Spring Boot Quartz Starter的依赖

```groovy
dependencies {
    // 添加Spring Boot Quartz Starter依赖
    compile('org.springframework.boot:spring-boot-starter-quartz')
}
```

#### 如何使用Quartz Scheduler

使用步骤：

1. 创建任务

   创建一个任务类，继承org.springframework.scheduling.quartz.QuartzJobBean，并重写executeInternal方法。

   示例代码：

   ```java
   package com.waylau.spring.cloud.weather.job;
   
   import org.quartz.JobExecutionContext;
   import org.quartz.JobExecutionException;
   import org.slf4j.Logger;
   import org.slf4j.LoggerFactory;
   import org.springframework.scheduling.quartz.QuartzJobBean;
   
   public class WeatherDataSyncJob extends QuartzJobBean {
       private final static Logger logger = LoggerFactory.getLogger(WeatherDataSyncJob.class);
       @Override
       protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
           logger.info("天气数据同步任务");
       }
   }
   ```

   

2. 创建配置类

   示例代码：

   ```java
   package com.waylau.spring.cloud.weather.config;
   
   import org.quartz.JobBuilder;
   import org.quartz.JobDetail;
   import org.quartz.SimpleScheduleBuilder;
   import org.quartz.Trigger;
   import org.quartz.TriggerBuilder;
   import org.springframework.context.annotation.Bean;
   import org.springframework.context.annotation.Configuration;
   import com.waylau.spring.cloud.weather.job.WeatherDataSyncJob;
   
   @Configuration
   public class QuartzConfiguration {
       @Bean
       public JobDetail weatherDataSyncJobJobDetail() {
           return JobBuilder.newJob(WeatherDataSyncJob.class).withIndentity("weatherDataSyncJob").storeDurably().build();
       }
       
       @Bean
       public Trigger sampleJobTrigger() {
           SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever();
           return TriggerBuilder.newTrigger().forJob(weatherDataSyncJobJobDetail()).witIdentity("weatherDataSyncTrigger").withSchedule(scheduleBuilder).build();
       }
   }
   ```

   其中：

   * JobDetail：定义了一个特定的Job。JobDetail实例可以使用JobBuilder API轻松构建。
   * Trigger：定义了何时来触发一个特定的Job；
   * withIntervalInSeconds(2)：意味着定时任务执行频率为每2秒执行一次。

   #### 定时同步天气数据

   定时任务需要更新所有城市的数据，所以需要遍历所有城市的ID。

   1. 需要城市的信息
   2. 将XMl解析为Java bean
   3. 城市数据服务接口及其实现
   4. 同步天气数据的接口
   5. 完善天气数据同步任务

   #### 完善配置

   #### 测试应用

   #### 使用Redis Desktop Manager

   ### 给天气预报一个“面子”

   #### 所需环境

   * JDK
   * Gradle
   * Spring Boot Web Starter
   * Apache HttpClient
   * Spring Boot Data Redis Starter
   * Redis
   * Spring Boot Quartz Starter
   * Quartz Scheduler
   * Spring Boot Thymeleaf Starter
   * Thymeleaf
   * Bootstrap

   #### 项目配置

   添加Spring Boot Thymeleaf Starter的依赖

   ```groovy
   dependencies {
       //...
       // 添加Spring Boot Thymeleaf Starter的依赖
       compile('org.springframework.boot:spring-boot-starter-thymeleaf')
   }
   ```

   

   #### 天气预报服务的需求

   天气预报服务的需求大概有以下几点：

   * 天气预报服务可以按照不同的城市来进行查询。
   * 天气预报服务可以查询近几天的天气信息。
   * 天气预报服务提供了天气预报的直观查询，其界面简洁、优雅。

   #### 天气预报服务接口及其实现

   #### 控制层实现

   #### 编写前台界面

   1. 配置Thymeleaf
   2. 页面实现
   3. 选择城市

   #### 测试应用

   ### 如何进行微服务的拆分

   #### 微服务拆分的意义

   1. 微服务易于实现
   2. 微服务易于维护
   3. 微服务易于部署
   4. 微服务易于更新

   #### 拆分的原则

   1. 单一职责原则

      单一职责原则（Single Responsibility Principle，SRP）又称单一功能原则，是面向对象的五大原则（SOLID）之一。

      在架构中，业界普遍采用的是分层架构。分层的原则之一就是每以层都是专注与自己所处的那一层的业务功能，及遵守单一职责的原则。划分微服务时也要遵循单一职责原则，每个微服务只专注与解决一个业务功能。通过DDD的指导，可以更加清楚地划分不同业务之间的界限。

   2. 高内聚

      内聚性又称为内联系，是指模块功能强度的度量，即一个模块内部各个元素彼此结合的紧密程度的一种度量。若一个模块内各元素联系得越紧密，则它的内聚性就越高。

      程序员希望把相关额行为都聚集在一起，把不相干的行为放到其他地方。这样，当它们要修改某个行为时，只需要在一个地方修改即可，然后就能对该修改及早地进行发布。如果要在很多不同的地方做修改，那么就需要同时发布多个微服务才能交付这个功能。在很多不同的地方进行修改会很慢，同时也引入了很多测试的工作量，而且部署多个服务的风险也更加高。

      所以，确定问题域的边界，保证相关的行为能够放置在相同的地方，并且确保它们与其他边界以尽量低耦合的方式进行通信。

   3. 低耦合

      耦合性也称块间联系，是指软件系统结构中各模块间相互联系紧密程度的一种度量。模块之间联系越紧密，其耦合性就越强，模块的独立性则越差。模块间耦合程度的高低取决于模块间的接口的复杂性、调用的方式及传递的信息。

      服务间的低耦合是指修改一个服务，就不需要修改另一个服务。使用微服务最重要的一点就是能够独立修改及部署单个服务，而不需要修改系统的其他服务组件。

   4. 恰当的“微”

      微服务也不是越小越好。服务越小，微服务架构的优点和缺点就会越来越明显。服务越小，微服务的独立性就会越高，但同时，微服务的数量也会激增，管理这些大批量的服务也将会是一个挑战。所以服务的拆分也要考虑场景。

   5. 拥抱变化

      好的系统架构都不是一蹴而就的，而是通过不断地完善、不断地演进而来。在构建微服务架构时也是如此，应该是一个循序渐进的过程，允许架构在适当的是否做出调整，做出改变。

   #### 拆分的方法

   1. 横向拆分

      横向拆分，即按照不同的业务功能，拆分成不同的微服务。

   2. 纵向拆分

      纵向拆分，即把一个业务功能里的不同模块或组件进行拆分。

   3. 使用DDD

      一个微服务，应该能反映出某个业务的领域模型。使用DDD，不但可以减少微服务环境中通用语言的复杂性，而且可以帮助团队搞清楚领域的边界，厘清上下文边界。

      建议把每个微服务都设计成一个DDD限界上下文（Bounded Context）。这位系统内的微服务提供了一个逻辑边界，无论是在功能还是通用语言上。

   ### 领域驱动设计与业务建模

   #### 什么是通用语言

   领域驱动设计的一个核心原则是使用一种基于模型的语言。因为模型是软件满足领域的共同点，它很适合作为这种通用语言的构造基础，这种语言称为“通用语言（Ubiqutious Language）”。通过语言连接起设计中的所有部分，是建立设计团队良好工作的前提。

   #### 领域驱动设计的核心概念

   1. 模型驱动设计（Model Driven Design）

      模型在构建是就考虑到软件的设计，而开发人员要参与到整个建模的过程中来。这样就能够选择一个能恰当在软件中表现的模型，设计过程会很顺畅并且始终是忠于模型的。

   2. 分层架构（Layered Architecture）

      将应用划分成分离的层并建立层间的交换规则很重要。如果代码没有被清晰隔离到某层中，它会马上变得混乱，变得非常难以管理和变更。

   3. 实体（Entity）

      实体是指带有标识符的对象，它的标识符在历经软件的各种状态后仍能保持一致。

      通常标识符或者是对象的一个属性（胡属性的组合），一个专门为保存和表现标识符而创建的属性，抑或是一种行为。

      实体是领域模型中非常重要的对象，并且它们应该在建模过程开始时就被考虑。

   4. 值对象（Value Object）

      实体是可以被跟踪的，但跟踪和创建标识符需要一定的成本。

      用来描述领域的特殊方面，且没有标识符的一个对象，称为值对象。

      区分实体对象和值对象非中必要。没有标识符，值对象就可以被轻易地创建或丢弃。再没有其他对象引用时，垃圾回收会处理这个对象。者极大地简化了设计，同时对性能也是非常大的提升。

      值对象由一个构造器创建，并且在它们的生命周期内永远不会被修改。当希望一个对象拥有不同的值时，就会简单地去创建另一个对象。者会对设计产生重要的结果。如果值对象保持不变，并且布局有标识符，那么它就可以被共享了。

   5. 服务（Service）

      一个服务应该不是对通常属于领域对象操作的替代。开发人员不应该为每一个需要的操作建立一个服务。但是当一个操作凸显为一个领域中的重要概念时，就需要为它建立一个服务了。

      服务的特征：

      * 服务执行的操作设计一个领域概念，这个概念通常不属于一个实体或值对象。
      * 被执行的操作涉及领域中的其他对象。
      * 操作是无状态的。

   6. 模块（Module）

      对于一个大型的复杂项目而言，模型会趋向于越来越大。当模型最终大到作为整体也很难讨论时，理解不同部件之间的关系和交互将变得很困难。基于此原因，非常有必要将模型以模块方式进行组织。模块被用来作为组织相关概念和任务，以便降低软件复杂性的一种非常简单有效的方法。

      使用模块另一方面也可以提高代码质量。好的软件代码应该具有高内聚性和低耦合度。

   7. 聚合（Aggregate）

      聚合是一种用来定义对象所有权和边界的领域模式。

      聚合是针对数据变化可以考虑一个单元的一组关联的对象。聚合使用边界将内部和外部的对象划分开来。每个聚合都有一个根。这个根是一个实体，并且它是外部可以访问的唯一的对象。根对象可以持有对任意聚合对象的引用，其他的对象可以互相持有彼此的引用，但一个外部对象只能持有对根对象的引用。如果边界还有其他的实体，那些实体的标识符是本地化的，只在聚合内有意义。

   8. 资源库（Repository）

      使用资源库的目的是封装所有获取对象引用所需的逻辑。领域对象无须处理基础设施，便可以得到领域中对其他对象所需的应用。这种从资源库中获取引用的方式，可以让模型重获它应用的清晰和焦点。

   #### 利用DDD来进行微服务的业务建模

   1. 利用限界上下文来拆分微服务

   2. 使用领域事件进行服务间的解耦

      领域事件（Domain Events）是DDD中的一个概念，用于捕获建模领域中所发生的事情。

      通过引入领域事件，给软件带来如下好处：

      * 帮助用户是很如理解领域模型：因为只有理解了领域模型，才能更好地设计领域事件。
      * 解耦微服务：这也是最终的目的。事件就是为了更好地处理服务间的依赖。

   ## 天气预报系统的微服务架构设计与实现

   ### 天气预报系统的架构设计

   #### 天气预报系统的改造需求

   #### 天气预报系统的微服务拆分

   #### 微服务代码的拆分

   拆分成如下微服务：

   * msa-weather-collection-server：天气数据采集微服务。
   * msa-weather-data-server：天气数据API微服务。
   * msa-weather-city-server：城市数据API微服务。
   * msa-weather-report-server：天气预报微服务。

   #### 系统的数据流向

   #### 系统的通信统计

   #### 系统的存储设计

   ### 天气数据采集微服务的实现

   #### 所需环境

   * JDK
   * Gradle
   * Spring Boot Web Starter
   * Apache HttpClient
   * Spring Boot Data Redis Starter
   * Redis
   * Spring Boot Quartz Starter
   * Quartz Scheduler

   #### 新增天气数据采集服务接口及实现

   #### 修改天气数据同步任务

   #### 配置类

   1. RestConfiguration
   2. QuartzConfiguration

   #### 值对象

   #### 工具类

   #### 清理前端代码、配置及测试用例

   #### 测试和运行

   ### 天气数据API微服务的实现

   #### 所需环境

   * JDK
   * Gradle
   * Spring Boot Web Starter
   * Spring Boot Data Redis Starter
   * Redis

   #### 修改天气数据服务接口及实现

   #### 调整控制层的代码

   #### 删除配置类、天气数据同步任务和工具类

   #### 清理值对象

   #### 清理前端代码、配置及测试用例

   #### 测试和运行

   #### 天气预报微服务的实现

   #### 所需环境

   * JDK
* Gradle
   * Spring Boot Web Starter
* Spring Boot Thymeleaf Starter
   * Thymeleaf
* Bootstrap
  
#### 修改天气预报服务接口及实现

#### 调整控制层的代码

#### 删除配置类、天气数据同步任务和工具类

#### 清理值对象

#### 清理测试用例和配置文件

#### 测试和运行

### 城市数据API微服务的实现

#### 所需环境

* JDK
   * Gradle
* Spring Boot Web Starter
  
#### 调整服务层代码

#### 调整控制层的代码

#### 删除配置类和天气数据同步任务

#### 清理值对象

#### 清理前端代码、配置及测试用例

#### 测试和运行

## 微服务的注册与发现

   ### 服务发现的意义

   服务发现，意味着用户的发布可以让其他人找到。在互联网里面，最常用的服务发现机制莫过于域名。通过域名，用户可以发现该域名所对应的IP，继而能够找到发布这个IP的服务。域名和主机的关系并非是一对一的，有可能多个域名都映射到了同一个IP下面。DNS（Domain Name System，域名系统）是因特网的一项核心服务，它作为可以将域名和IP地址相互映射的一个分布式数据库，能够是人更方便地访问互联网，而不用去记住能够被及其直接读取的IP地址串。

   #### 通过URI来访问服务

   用户要访问某个服务，势必要通过URI来找到哪个服务。URI（Uniform Resource Identifier，统一资源标识符）是一个用于标识某一个互联网资源名称的字符串。

   #### 通过IP访问服务的弊端

   首先，一个较大的问题是，IP与一台特定的主机关联。IP必须是唯一，不然会产生混淆。

   其次，要让服务的调用方记住服务方的IP地址很难。特别是当双方都还没有正式上线部署的时候，根本无法提前获知服务提供方的IP地址。

   最后一点是，通过IP地址很难做到负载均衡。

   #### 需要服务的注册和发现

   服务注册和发现正像互联网上的DNS，可以让用户启动的每个微服务都把自己注册进一个服务注册表（或称为注册中心），当其他微服务需要调用这个服务的时候，就通过服务的名称来获取到这个服务。因为多个服务实例都是映射到同一个服务名称的，所以通过服务名称来访问，就可以使用其中任何一个服务实例，就可以实现负载均衡了。

   #### 使用Eureka

   在Spring Cloud技术栈中，Eureka作为服务注册中心，对整个微服务架构起着最核心的整合作用。

   [Eureka项目地址](https://github.com/spring-cloud/spring-cloud-netflix)

   1. 完整的服务注册和发现机制
2. 和Spring Cloud无缝集成
   3. 高可用性
4. 开源
   
### 如何集成Eureka Server

#### 所需环境

* JDK
  
   * Gradle
   
* Spring Boot
   * Spring Cloud Starter Netflix Eureka Server

   #### 更改build.gradle配置

   ```groovy
//buildscript代码块中脚本优先执行
   buildscript {
    // ext用于定义动态属性
       ext {
           springBootVersion = '2.0.0.M3'
       }
       
       // 使用了Maven的中央仓库及Spring自己的仓库（也可以指定其他仓库）
       repositories {
           //mavenCentral()
           maven { url "https://repo.spring.io/snapshot" }
           maven { url "https://repo.spring.io/milestone" }
           maven { url "http://maven.aliyun.com/nexus/content/groups/public/" }
       }
       
       // 依赖关系
       dependencies {
           // classpath声明了再执行其他脚本时，ClassLoader可以使用这些依赖
           classpath("org.springframework.boot:spring-boot-gradle-plugin:${springBootVersion}")
       }
   }
   
   // 使用插件
   apply plugin: 'java'
   apply plugin: 'eclipse'
   apply plugin: 'org.springframework.boot'
   apply plugin: 'io.spring.dependency-management'
   
   // 指定了生成的编译文件的版本，默认是打包成了jar包
   group = 'com.waylau.spring.cloud'
   version = '1.0.0'
   
   // 指定编译.java文件的JDK版本
   sourceCompatibility = 1.8
   
   // 使用了Maven的中央仓库及Spring自己的仓库（也可以指定其他仓库）
   repositories {
       //mavenCentral()
       maven { url "https://repo.spring.io/snapshot" }
       maven { url "https://repo.spring.io/milestone" }
       maven { url "http://maven.aliyun.com/nexus/content/groups/public/" }
   }
   
   ext {
       springCloudVersion = 'Finchley.M2'
   }
   
   dependencies {
       
       // 添加Spring Cloud Starter Netflix Eureka Server依赖
       compile('org.springframework.cloud:spring-cloud-starter-netflix-eureka-server')
       
       // 该依赖用于测试阶段
       testCompile('org.springframework.boot:spring-boot-starter-test')
   }
   
   dependencyManagement {
       imports {
           mavenBom "org.springframework.cloud:spring-cloud-dependencies:${springCloudVersion}"
       }
   }
   ```
   
   
   
   #### 启用Eureka Server
   
   Application.java源代码：
   
   ```java
   import org.springframework.boot.SpringApplication;
   import org.springframework.boot.annotaion.SpringBootApplication;
   import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
   
   /**
    * 主应用程序
    */
   @SpringBootApplication
   @EnableEurekaServer
   public class Application {
       public static void main(String[] args) {
           SpringApplication.run(Application.class, args);
       }
   }
   ```
   
   
   
   #### 修改项目配置
   
   application.properties
   
   ```properties
   server.port: 8761
   
   eureka.instance.hostname: localhost
   eureka.client.registerWithEureka: false
   eureka.client.fetchRegistry: false
   eureka.client.serviceUrl.defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka/
   ```
   
   * server.port：指明了应用启动的端口号。
   * eureka.instance.hostname：应用的主机名称。
   * erurka.client.registerWithEureka：值为false表示自身仅作为服务，不作为客户端。
   * eureka.client.fetchRegistry：值为false表示无须注册自身。
   * eureka.client.serviceUrl.defaultZone：指明了应用的URL。
   
   #### 清空资源目录
   
   在src/main/resources目录下，除了application.properties文件外，其他没有用到的目录或文件都删除，特别是templates目录，因为这个目录会覆盖Eureka Server自带的管理界面。
   
   #### 启动
   
   ### 如何集成Eureka Client
   
   #### 所需环境
   
   * JDK
   * Gradle
   * Spring Boot
   * Spring Cloud Starter Netflix Eureka Client
   
   #### 更改build.gradle配置
   
   build.gradle源码：
   
   ```groovy
   dependencies {
       // 添加Spring Cloud Starter Netflix Eureka Client依赖
       compile('org.springframework.cloud:spring-cloud-starter-netflix-eureka-client')
       // 该依赖用于测试阶段
       testCompile('org.springframework.boot:spring-boot-starter-test')
   }
   ```
   
   
   
   #### 一个最简单的Eureka Client
   
   Application.java源代码：
   
   ```java
   import org.springframework.boot.SpringApplication;
   import org.springframework.boot.annotaion.SpringBootApplication;
   import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
   
   /**
    * 主应用程序
    */
   @SpringBootApplication
   @EnableDiscoveryClient
   public class Application {
       public static void main(String[] args) {
           SpringApplication.run(Application.class, args);
       }
   }
   ```
   
   
   
   #### 修改项目配置
   
   application.properties内容：
   
   ```properties
   spring.application.name: micro-weather-eureka-client
   eureka.client.serviceUrl.defualtZone: http://localhost:8761/eureka/
   ```
   
   * spring.application.name：指定了应用的名称。
   * eureka.client.serviceUrl.defaultZone：指明了Eureka Server的位置。
   
   #### 运行和测试
   
   ### 实现服务的注册与发现
   
   #### 所需环境
   
   * JDK
   * Gradle
   * Redis
   * Spring Boot
   * Spring Cloud Starter Netflix Eureka Client
   
   #### 更改build.gradle配置
   
   #### 启用Eureka Client
   
   Application.java源代码：
   
   ```java
   import org.springframework.boot.SpringApplication;
   import org.springframework.boot.annotaion.SpringBootApplication;
   import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
   
   /**
    * 主应用程序
    */
   @SpringBootApplication
   @EnableDiscoveryClient
   public class Application {
       public static void main(String[] args) {
           SpringApplication.run(Application.class, args);
       }
   }
   ```
   
   
   
   #### 修改项目配置
   
   application.properties内容：
   
   ```properties
   spring.application.name: msa-weather-collection-eureka
   eureka.client.serviceUrl.defualtZone: http://localhost:8761/eureka/
   ```
   
   
   
   #### 运行和测试
   
   ## 服务的消费
   
   ### 微服务的消费模式
   
   基于HTTP的客户端经常被用作微服务的消费者。
   
   #### 服务直连模式
   
   服务直连模式是最容易理解的，例如，在浏览器里面访问某篇文章，我们知道这篇文章的URL，就能直接通过URL访问想要的资源。
   
   服务直连的特点：
   
   * 简洁明了。
   * 平台语言无关性。
   
   #### 客户端发现模式
   
   客户端发现模式是一种客户端来决定相应服务实例的网络位置的解决方案。原理如下：
   
   * 当服务实例启动后，将自己的位置信息提交到服务注册表（Service Registry）中。服务注册表维护者所有可用的服务实例的列表。
   * 客户端从服务注册表进行查询，来获取可用的服务实例。
   * 在选取得可用的服务实例的过程中，客户端自行使用负载均衡算法从多个服务实例中选择一个，然后发出请求。
   
   服务注册表中的实例也是动态变化的。当有新的实例启动时，实例会将实例信息注册到服务注册表中；当实例下线或不可用时，服务注册表也能及时感知到，并将不可用实例及时从服务注册表中清除。服务注册表可以采取类似心跳等机制来实现对服务实例的感知。
   
   Spring Cloud提供了完整的服务注册及服务发现的实现方式。Eureka提供了服务注册表的功能，为服务实例注册管理和查询可用实例提供REST API接口。Ribbon主要功能是提供客户端的软件负载均衡算法，将中间层服务连接在一起。Ribbon客户端组件提供一系列完善的配置项，在服务注册表所列出的实例，Ribbon会自动帮助你基于某种规则（如简单轮询、随机连接等）去连接这些实例。
   
   ZooKeeper是Apache基金会下的一个开源的、高可用的分布式应用协调服务。
   
   客户端发现模式的优点是，相对于直连模式，除了服务注册外，其他部分基本无须做改动。此外，由于客户端已经知晓所有可用的服务实例，所以能够针对特定应用来实现智能的负载均衡。
   
   客户端发现模式的缺点是，客户端需要与服务注册表进行绑定，要针对服务端用到的每个编程语言和框架，来实现客户端的服务发现逻辑。
   
   #### 服务端发现模式
   
   该模式是客户端通过负载均衡器向某个服务提出请求，负载均衡器查询服务注册表，并经请求转发到可用的服务实例。同客户端发现模式类似，服务实例在服务注册表中注册或注销。
   
   与客户端发现模式不同的是，服务端发现模式需要专门的负载均衡器来分发请求。这样客户端就可以保持相对简单，无须自己实现负载均衡机制。
   
   DNS域名解析可以提供最简单方式的服务端发现功能。它作为域名和IP地址相互映射的一个分布式数据库，能够使人更方便地访问互联网。
   
   在开源方面，Kubernetes(https://kubernetes.io)及NGINX(http://nginx.org/)也能作服务端发现的负载均衡器。
   
   服务端发现模式的好处是，它通常会简化客户端的开发工作，因为客户端并不需要关心负载均衡的细节工作，它所要作的就是将请求发到负载均衡器即可。
   
   实施服务端发现模式的难点，一个较大的问题的是需要考虑如何来配置和管理负载均衡器称为高可用的系统组件。
   
   ### 常见微服务的消费者
   
   #### Apache HttpClient
   
   Apache HttpClient是Apache Jakarta Common下的子项目，用来提供高效的、最新的、功能丰富的支持HTTP的客户端编程工具包，并且支持HTTP最新的版本和建议。
   
   RestTemplate是Spring的核心类，用于同步客户端的HTTP访问。它简化了与HTTP服务器的通信，并强制执行RESTful原则。
   
   要使用Apache HttpClient，最简便的方式就是直接添加Apache HttpClient依赖：
   
   ```groovy
   dependencies {
       compile('org.apache.httpcomponents:httpclient:4.5.3')
   }
   ```
   
   然后通过RestTemplateBuilder来创建RestTemplate实例：
   
   ```java
   import org.springframework.beans.factory.annotation.Autowired;
   import org.springframework.boot.web.client.RestTemplateBuilder;
   import org.springframework.context.annotation.Bean;
   import org.springframework.context.annotation.Configuration;
   import org.springframework.web.client.RestTemplate;
   
   @Configuration
   public class RestConfiguration {
       
       @Autowired
       private RestTemplateBuilder builder;
       
       @Bean
       public RestTemplate restTemplate() {
           return builder.build();
       }
   }
   ```
   
   
   
   #### Ribbon
   
   Spring Cloud Ribbon 是基于Netflix Ribbon实现的一套客户端负载均衡的工具。它是一个基于HTTP和TCP的客户端负载均衡器。
   
   Ribbon的一个中心概念就是命名客户端。每个负载均衡器都是组合整个服务组件的一部分，它们一起协作，并可以根据需要与远程服务器进行交互，获取包含命名客户端名称的集合。
   
   Ribbon经常与Eureka结合使用。Eureka为所有微服务实例提供服务注册，而Ribbon提供服务消费的客户端。
   
   负载均衡策略：
   
   * 简单轮询负载均衡。
   * 加权响应时间负载均衡。
   * 区域感知轮询负载均衡。
   * 随机负载均衡。
   
   其中，区域感知负载均衡器是Ribbon一个久经考验的功能，该负载均衡器会采取如下步骤：
   
   * 负载均衡器会检查 、计算所有可用区域的状态。如果某个区域中平均每个服务器的活跃请求已经达到配置的阈值，该区域将从活跃服务列表中排除。如果多余一个区域已经达到阈值，平均每服务器拥有最多活跃请求的区域将被排除。
   * 最差的区域被排除后，从剩下的的区域中，将按照服务器实例数的概率抽样选择一个取悦。
   * 在选定区域总，将会根据给定负载均衡策略规则返回一个服务器。
   
   1. 所需环境
      * JDK
      * Gradle
      * Redis
      * Spring Boot
      * Spring Cloud Starter Netflix Eureka Client
      * Spring Cloud Starter Netflix Ribbon
      
   2. 项目配置
   
      添加Ribbon依赖
   
      ```groovy
      pendencies {
          //...
          compile('org.springframework.cloud:spring-cloud-starter-netflix-ribbon')
      }
      ```
   
      
   
   3. 启用Ribbon
   
      Spring Cloud提供了声明式@RibbonClient注解来使用Ribbon。
   
      ```java
      package com.waylau.spring.cloud.weather.config;
      
      import org.springframework.beans.factory.annotation.Autowired;
      import org.springframework.boot.client.RestTemplateBuilder;
      import org.springframework.cloud.client.loadbalancer.LoadBalanced;
      import org.springfarmework.cloud.netflix.ribbon.RibbonClient;
      import org.springframework.context.annotation.Bean;
      import org.springframework.context.annotation.Configuration;
      import org.springframework.web.client.RestTemplate;
      
      @Configuration
      @RibbonClient(name = "ribbon-client", configuration = RibbonConfiguration.class)
      public class RestConfiguration {
          @Autowired
          private RestTemplateBuilder builder;
          
          @Bean
          @LoadBalanced
          public RestTemplate restTemplate() {
              return builder.build();
          }
      }
      ```
   
      ```java
      package com.waylau.spring.cloud.weather.config;
      
      import org.springframework.cloud.netflix.ribbon.ZonePreferenceServiceListFilter;
      import org.springframework.context.annotation.Bean;
      import org.springframework.context.annotation.Configuration;
      
      import com.netflix.loadBalancer.IPing;
      import com.netflix.loadBalancer.PingUrl;
      
      @Configuration
      public class RibbonConfiguration {
          @Bean
          public ZonePreferenceServerListFilter serverListFilter() {
              ZonePreferenceServerListFilter filter = new ZonePreferenceServerListFilter();
              filter.setZone("myZone");
              return filter;
          }
          
          @Bean
          public IPing ribbonPing() {
              return new PingUri();
          }
      }
      ```
   
      
   
   4. 使用Ribbon
   
      编写CityController，用于使用Ribbon配置的RestTemplate。
   
      ```java
      import org.springframework.beans.factory.annotation.Autowired;
      import org.springframework.web.bind.annotation.GetMapping;
      import org.springframework.web.client.RestTemplate;
      
      @RestController
      public class CityController {
          @Autowired
          private RestTemplate restTemplate;
          
          @GetMapping("/cities")
          public String listCity() {
              // 通过应用名称来查找
              String body = restTemplate.getForEntity("http://msa-weather-city-eureka/cities", String.class).getBody();
              return body;
          }
      }
      ```
   
      
   
   5. 应用配置
   
      application.properties文件内容：
   
      ```properties
      spring.application.name=micro-weather-eureka-client-ribbon
      eureka.client.serviceUrl.defaultZone=http://localhost:8761/eureka/
      ```
   
      
   
   #### Feign
   
   1. 所需环境
   
      * Gradle
      * Redis
      * Spring Boot
      * Spring Cloud Stater Netflix Eureka Client
      * Spring Cloud Starter Open Feign
   
   2. 项目配置
   
      为了使用Feign，增加以下配置：
   
      ```groovy
      dependencies {
          // 添加Spring Cloud Starter OpenFeign依赖
          compile('org.springframework.cloud:spring-cloud-starter-openfeign')
      }
      ```
   
      
   
   3. 启用Feign
   
      要启用Feign，最简单的方式就是在应用的根目录的Application类上添加org.springframework.cloud.openfeign.EnableFeignClients注解。
   
   4. 使用Feign
   
      要使用Feign，首先要编写Feign请求接口。
   
      ```java
      package com.waylau.spring.cloud.weather.service;
      
      import org.springframework.cloud.openfeign.FeignClient;
      import org.springframework.cloud.bind.annotation.GetMapping;
      
      @FeignClient("mas-weather-city-eureka")
      public interface CityClient {
          @GetMapping("/cities")
          public String listCity();
      }
      ```
   
      在控制器中使用该接口的实现。
   
      ```java
      package com.waylau.spring.cloud.weather.controller;
      
      import org.springframework.bean.factory.annotation.Autowired;
      import org.springframework.web.bind.annotation.GetMapping;
      import org.springframework.web.bind.annotation.RestController;
      
      import com.waylau.spring.cloud.weather.service.CityClient;
      
      @RestController
      public class CityController {
          @Autowired
          private CityClient cityClient;
          
          @GetMapping("/cities")
          public String listCity() {
              // 通过Feign客户端来查找
              String body = cityClient.listCity();
              return body;
          }
      }
      ```
   
      
   
   ### 使用Feign实现服务的消费者
   
   #### 天气数据采集微服务使用Feign
   
   1. 项目配置
   
      为了使用Feign，在build.gradle文件中增加以下配置。
   
      ```groovy
      dependencies {
          //...
          compile('org.springframework.cloud:spring-cloud-starter-openfeign')
      }
      ```
   
      
   
   2. 启用Feign
   
      要启用Feign，在应用的根目录的Application上添加org.springframework.cloud.openfeign.EnableFeignClients注解即可。
   
   3. 修改WeatherDataSyncJob
   
      首先，定义一个Feign客户端CityClient。
   
      ```java
      package com.waylau.spring.cloud.weather.service;
      
      import java.util.List;
      
      import org.springframework.cloud.netflix.feign.FeignClient;
      import org.springframework.web.bind.annotation.GetMapping;
      
      import com.waylau.spring.cloud.weather.vo.City;
      
      @FeignClient("msa-weather-city-eureka")
      public interface CityClient {
          @GetMapping("/cities")
          public List<City> listCity() throws Exception;
      }
      ```
   
      在需要获取外部服务的WeatherDataSyncJob类中，使用CityClient接口即可。
   
      ```java
      package com.waylau.spring.cloud.weather.job;
      
      import java.util.List;
      
      import org.quartz.JobExecutionContext;
      import org.quartz.JobExcecutionException;
      import org.slf4j.Logger;
      import org.slf4j.LoggerFactory;
      import org.springframework.beans.factory.annotation.Autowired;
      import org.springframework.scheduling.quartz.QuartzJobBean;
      
      import com.waylau.spring.cloud.weather.service.CityClient;
      import com.waylau.spring.cloud.weather.service.WeatherDataCollectionService;
      import com.waylau.spring.cloud.weather.vo.City;
      
      public class WeatherDataSyncJob extends QuartzJobBean {
          private final static Logger logger = LoggerFactory.getLogger(WeatherDataSyncJob.class);
          
          @Autowired
          private WeatherDataCollectionService weatherDataCollectionService;
          
          @Autowired
          private CityClient cityClient;
          
          protected void executeInternal(JobExcectionContext context) throws JobExecutionExcception {
              logger.info("Start天气数据同步任务");
              
              // 由城市数据API微服务来提供数据
              List<City> cityList = null;
              try {
                  // 调用城市数据API
                  cityList = cityClient.listCity();
              } catch (Exception e) {
                  logger.error("获取城市信息异常！", e);
                  throw new RuntimeException("获取城市信息异常！", e);
              }
              
              for(City city : cityList) {
                  String cityId = city.getCityId();
                  logger.info("天气数据同步任务中，cityId:" + cityId);
                  
                  // 根据城市ID同步天气数据
                  weatherDataCollectionService.syncDataByCityId(cityId);
              }
              
              logger.info("End 天气数据同步任务");
          }
      }
      ```
   
      
   
   4. 修改项目配置
   
      最后，修改application.properties。
   
      ```properties
      spring.application.name=msa-weather-collection-eureka-feign
      eureka.client.serviceUrl.defaultZone=http://localhost:8761/eureka/
      feign.client.config.feignName.connectionTimeout=5000
      feign.client.config.feignName.readTimeout=5000
      ```
   
      
   
   #### 天气预报微服务使用Feign
   
   1. 项目配置
   
      为了使用Feign，在build.gradle文件中增加如下配置：
   
      ```groovy
      dependencies: {
          //...
          compile('org.springframework.cloud:spring-cloud-starter-openfeign')
      }
      ```
   
      
   
   2. 启用Feign
   
      要启用Feign，在应用根目录的Application类上添加org.springframework.cloud.openfeign.EnableFeignClients注解即可。
   
   3. 定义Feign客户端
   
      首先定义一个Feign客户端CityClient，从城市数据API微服务msa-weather-city-eureka中获取城市的信息。
   
      ```java
      package com.waylau.spring.cloud.weather.service;
      
      import java.util.List;
      
      import org.springframework.cloud.netflix.feign.FeignClient;
      import org.springframework.web.bind.annotation.GetMapping;
      
      import com.waylau.spring.cloud.weather.vo.City;
      
      @FeignClient("msa-weather-city-eureka")
      public interface CityClient {
          @GetMapping("/cities")
          public List<City> listCity() throws Exception;
      }
      ```
   
      再定义一个Feign客户端WeatherDataClient，从天气数据API微服务msa-weather-data-eureka中获取天气数据。
   
      ```java
      package com.waylau.spring.cloud.weather.service;
      
      import org.springframework.cloud.openfeign.FeignClient;
      
      import com.waylau.spring.cloud.weather.vo.WeatherResponse;
      
      @FeignClient("msa-weather-data-eureka")
      public interface WeatherDataClient {
          @GetMapping("/weather/cityId/{cityId}")
          public WeatherResponse getDataByCityId(@PathVariable("cityId") String cityId);
      }
      ```
   
      
   
   4. 修改天气预报服务
   
      修改天气预报服务WeatherReportServiceImpl，将原有的伪造的数据该从Feign客户端获取天气数据API微服务提供的数据。
   
      ```java
      package com.waylau.spring.cloud.weather.service;
      
      import org.springframework.beans.factory.annotation.Autowired;
      import org.springframework.stereotype.Service;
      
      import com.waylau.spring.cloud.weather.vo.Weather;
      import com.waylau.spring.cloud.weather.vo.WeatherResponse;
      
      @Service
      public class WeatherReportServiceImpl implements WeatherReportService {
          
          @Autowired
          private WeatherDataClient weatherDataClient;
          
          @Override
          public Weather getDataByCityId(String cityId) {
              WeatherResponse response = weatherDataClient.getDataByCityId(cityId);
              return response.getData();
          }
      }
      ```
   
      
   
   5. 修改天气预报控制器
   
      修改天气预报控制器WeatherReportController，将原有的伪造的城市数据改为由CityClient来获取城市数据API微服务中的城市数据。
   
      ```java
      package com.waylau.spring.cloud.weather.controller;
      
      import java.util.List;
      
      import org.slf4j.Logger;
      import org.slf4j.LoggerFactory;
      import org.springframework.beans.factory.annotation.Autowired;
      import org.springframework.ui.Model;
      import org.springframework.web.bind.annotation.GetMapping;
      import org.springframework.web.bind.annotation.PathVariable;
      import org.springframeowrk.web.bind.annotation.RequestMapping;
      import org.springframework.web.bind.annotation.RestController;
      import org.springframework.web.servlet.ModelAndView;
      
      import com.waylau.spring.cloud.weather.service.CityClient;
      import com.waylau.spring.cloud.weather.service.WeatherResponseService;
      improt com.waylau.spring.cloud.weather.vo.city;
      
      @RestController;
      @RequestMapping("/report")
      public class WeatherReprotController {
          private final static Logger logger = LoggerFactory.getLogger(WeatherReportController.class);
          
          @Autowired
          private CityClient cityClient;
          
          @Autowired
          private WeatherReportService weatherReportService;
          
          public ModelAndView getReportByCityId(@PathVariable("cityId") String cityId, Model model) throws Exception {
              List<City> cityList = null;
              try {
                  cityList = cityClient.listCity();
              } catch (Exception e) {
                  logger.error("获取城市信息异常！", e);
                  throw new RuntimeException("获取城市信息异常！", e);
              }
              model.addAttribute("title", "老卫的天气预报");
              model.addAttribute("cityId", cityId);
              model.addAttribute("cityList", cityList);
              model.addAttribute("report", weatherReprotService.getDataByCityId(cityId));
              return new ModelAndView("weather/report", "reportModel", model);
          }
      }
      ```
   
      
   
   6. 修改项目配置
   
      最后，修改application.properties。
   
      ```properties
      spring.application.name=msa-weather-collection-eureka-feign
      eureka.client.serviceUrl.defaultZone=http://localhost:8761/eureka/
      feign.client.config.feignName.connectionTimeout=5000
      feign.client.config.feignName.readTimeout=5000
      ```
   
      
   
   ### 实现服务的负载均衡及高可用
   
   #### 天气预报系统的微服务
   
   #### 运行微服务实例
   
   #### 测试天气预报服务
   
   ## API网关
   
   ### API网关的意义
   
   API网关旨在用一套单一且统一的API入口点，来组合一个或多个内部API。
   
   API网关定位为应用系统服务接口的网关，区别与网络技术的网关，但是原理是一样的。API网关统一服务入口，可方便实现对平台众多服务接口进行管控。
   
   #### API并不能适用于所有场景
   
   API网关常用与以下场景：
   
   * 黑白名单：实现通过IP地址控制进制访问网关功能。
   * 日志：实现访问日志的记录，可用于分析访问、处理性能指标，同时将分析结果支持其他模块功能应用。
   * 协议适配：实现通信协议校验、适配转换的功能。
   * 身份认证：负责网关访问身份认证校验。
   * 计流权限：实现微服务访问流量计算，基于流量计算分析进行限流，可以定义多种限流规则。
   * 路由：是API网关很核心的模块功能，此模块实现根据请求锁定目标微服务，并将请求进行转发。
   
   #### API网关锁带来的好处
   
   1. 避免将内部信息泄漏该外部
   2. 为微服务添加额外的安全层
   3. 支持混合通信协议
   4. 降低构建微服务的复杂性
   5. 微服务模拟与虚拟化
   
   #### API网关的弊端
   
   * 由于额外API网关的加入，会使整个开发在架构上考虑更多的编排和管理工作。
   * 在开发过程中，对路由逻辑配置要进行统一的管理，从而能够确保以合理的路由方式对外部API与专用微服务。
   * 除非架构本身充分适合高可用性与规模化要求，否则API网关往往会成为一项限制性因素，甚至引发单点故障。
   
   ### 场景API网关的实现方式
   
   #### NGINX
   
   NGINX是一个免费的、开源的、高性能的HTTP服务器和反向代理，以及一个IMAP/POP3代理服务器。NGINX以其高性能、稳定性、丰富的功能集、简单的配置和低资源消耗而闻名。
   
   与传统服务器不同，NGINX不依赖于线程来处理请求。相反，它使用可扩展的事件驱动（异步）架构。这种架构在负载下使用晓得但更重要的可预测的内存量。即使用于不希望处理数千个并发请求，仍然可以从NGINX的高性能和小内存中获益。
   
   NGINX具有很多非常优越的特性：
   
   * 作为Web服务器：相比Apache，NGINX使用更少的资源，支持更多的并发连接，体现更高的效率，这点使NGINX尤其受到虚拟主机提供商的欢迎。
   * 作为负载均衡服务器：NGINX既可以在内部直接支持Rails和PHP，也可以支持作为HTTP代理服务器对外进行服务。NGINX用C语言编写，系统资源开销小，CPU使用效率高。
   * 作为邮件代理服务器：NGINX同时也是一个非常优秀的邮件代理服务器（最早开发这个产品的目的之一也是作为邮件代理服务器）。
   
   **将NGINX作为API网关**
   
   NGINX的一个配置例子：
   
   ```nginx
   server {
       listen 80;
       server_name example.org www.example.org;
   }
   
   server {
       listen 80;
       server_name *.example.org;
   }
   
   server {
       listen 80;
       server_name mail.*;
   }
   server {
       listen 80;
       server_name ~^(?<user>.+)\.example\.net$;
   }
   ```
   
   
   
   #### Spring Cloud Zuul
   
   Zuul是Netflix公司开源的一个API网关组件，提供了认证、鉴权、限流、动态路由、监控、弹性、安全、负载均衡、协助单点压测、静态响应等边缘服务的框架。
   
   Zuul的基本功能：
   
   * 验证与安全保障：识别面向各类资源的验证要求并拒绝哪些与要求不符的请求。
   * 审查与监控：在边缘位置跟踪有意义的数据及统计结果，从而为用户带来准却的生产状态结论。
   * 动态路由：以动态方式根据需要将请求路由至不同后端集群处。
   * 压力测试：逐渐增加执行集群的负载流量，从而计算性能水平。
   * 负载分配：为每一种负载类型分配对响应容量，并弃用超出限定值的请求。
   * 静态响应处理：在边缘位置直接建立部分响应，从而避免其流入内部集群。
   
   #### Kong
   
   Kong是专注与提供微服务API网关的管理水平，它本省是基于NGINX，但比NGINX提供了更简单的配置方式，并且提供了一些优秀的插件，如验证、日志、调用频次限制等。
   
   Kong另外一个强大之处在于提供了大量的插件来扩展应用，通过设置不同的插件，可以为服务提供各种增强的功能。[Kong插件平台](https://konghq.com/plugins/)
   
   Kong具有以下特性：
   
   * 支持云部署：可以运行在Kubernetes管理的平台上
   * 动态负载均衡
   * 服务器发现
   * WebSocket
   * OAuth2.0
   * 日志
   * 安全：ACL（访问控制）、CORS（跨域资源共享）、动态SSL、IP限制、爬虫检测实现
   * 系统日志
   * SSL
   * 监控
   * 认证：HMAC、JWT、Basic等
   * 速率限制
   * 缓存
   * REST API
   * 集群
   * 可扩展
   
   ### 如何集成Zuul
   
   #### Zuul简介
   
   Zuul是Netflix出品的一个基于JVM路由和服务端的负载均衡器。
   
   Zuul功能如下：
   
   * 认证
   * 压力测试
   * 金丝雀测试
   * 动态路由
   * 负载削减
   * 安全
   * 静态响应处理
   * 主动/主动交换管理
   
   #### 所需环境
   
   * JDK
   * Gradle
   * Spring Boot
   * Spring Cloud Starter Netflix Eureka Client
   * Spring Cloud Starter Netflix Zuul
   
   #### 更改配置
   
   ```groovy
   dependencies {
       //...
       compile('org.springframeowrk.cloud:spring-cloud-starter-netflix-zuul')
   }
   ```
   
   
   
   #### 使用Zuul
   
   要启用Zuul，最简单的方式就是在应用的根目录Application类上添加org.springframework.cloud.netflix.zuul.EnableZuulProxy注解。
   
   其次，@EnableZuulProxy启用了Zuul作为反向代理服务器。
   
   最后，修改配置。
   
   ```properties
   spring.application.name=micro-weather-eureka-client-zuul
   eureka.client.serviceUrl.defaultZone=http://localhost:8761/eureka/
   zuul.routes.hi.path=/hi/**
   zuul.routes.hi.serviceId=micro-weather-eureka-client
   ```
   
   * zuul.routers.hi.path：为要拦截请求的路径。
   * zuul.routers.hi.serviceId：为要拦击请求的路径所要映射的服务。
   
   #### 运行和测试
   
   ### 实现API网关
   
   #### 配置API网关
   
   在micro-weather-eureka-client-zuul的基础上，创建一个新的应用msa-weather-eureka-client-zuul。
   
   application.properties配置如下：
   
   ```properties
   spring.application.name=msa-weather-eureka-client-zuul
   eureka.client.serviceUrl.defaultzone=http://localhost:8761/eureka/
   zuul.routes.city.path=/city/**
   zuul.routes.city.serviceId=msa-weather-city-eureka
   zuul.routes.data.path=/data/**
   zuul.routes.data.serviceId=msa-weather-data-eureka
   ```
   
   
   
   #### 修改新的天气预报微服务
   
   1. 修改Feign客户端
   
      删除CityClient、WeatherDataClient，并创建DataClient用于获取城市列表数据及天气数据。
   
      ```java
      package com.waylau.spring.cloud.weather.service;
      
      import java.util.List;
      
      import org.springframework.cloud.netflix.feign.FeignClient;
      import org.springframework.web.bind.annotation.GetMapping;
      import org.springframework.web.bind.annotation.PathVariable;
      
      import com.waylau.spring.cloud.weather.vo.City;
      import com.waylau.spring.cloud.weather.vo.WeatherResponse;
      
      @FeignClient("msa-weather-eureka-client-zuul")
      public interfac DataClient {
          @GetMapping("/city/cities")
          public List<City> listCity() throws Exception;
          
          @GetMapping("/data/weather/cityId/{cityId}")
          public WeatherResponse getDataByCityId(@PathVariable("cityId") String cityId);
      }
      ```
   
      同时，将依赖WeatherDataClient和CityClient的地方修改为DataClient。
   
   2. 修改应用配置
   
   #### 运行微服务实例
   
   ## 微服务的部署与发布
   
   ### 部署微服务将面临的挑战
   
   #### 部署微服务将面临的问题
   
   1. 运维负担
   2. 服务间的依赖
   3. 更多的监控
   4. 更频繁的发布
   5. 更复杂的测试
   
   #### 如何解决上述问题
   
   1. 自动化运维
   2. 处理服务间的依赖关系
   3. 日志收集
   4. 监控和告警
   5. 微服务的发布
   6. API版本控制
   
   ### 持续交付与持续部署微服务
   
   持续集成（Continuous Integration）与持续交付（Continuous Delivery）、持续部署（Continuous Deployment）作为敏捷开发实践，可以及早发现、解决问题，从而更早地将产品交付给客户。及早地从客户那里得到反馈，就可以及早地对产品进行修复和完善，交付更加完每的产品给客户，最终形成了良好的可以持续的闭环。
   
   #### 什么是持续交付与持续部署
   
   持续集成是持续交付和持续部署的基础。持续集成使得整个开发团队保持一致，消除了继承所引起的问题的延期。
   
   所谓交付，就是将最终的产品发布到线上环境，提供给用户使用。对于一个微服务架构系统来说，将一个应用拆分成多个独立的服务，每个服务都具有业务属性，并且能独立地被开发、测试、构建、部署。换言之，每个服务都是一个可交付的产品。
   
   持续交付是一系列的开发实践方法，用来确保代码能够快速、安全地部署到产品环境中，它通过将每一次改动都提交到一个模拟产品环境中，使用严格的自动化测试，确保业务应用和服务能符合预期。因为使用完全的自动化过程来把每个变更自动提交到测试环境中，所以当业务开发完成时，有信息只需要按一次按钮，就能将应用安全部署到生产环境中。
   
   而持续部署是持续交付的更高一级的阶段。即当所有代码的改动都通过了自动化测试之后，都能够自动地部署到生产环境里。持续交付与持续部署一个重要的差别在于，持续发布需要人工来将应用部署到生产环境中（即部署前，应用需要人工来校验一遍），而持续部署则是所有流程都是自动化的，包括部署到生产环境的流程。
   
   #### 持续交付与持续部署的意义
   
   总的来说，持续交付与持续部署都在敏捷开发过程中，实现速度、效率、质量的软件开发实践，可以持续为用户交付可用的软件产品。其中包括：
   
   * 频繁的交付周期带来了更迅速的对软件的反馈。
   * 可以速度对产品进行改进，更好地使用用户的需求和市场的变化。
   * 需求分析、产品的用户体验和交付设计、开发、测试、运维等角色密切协作，相比于传统的瀑布式软件团队，减少了浪费。
   * 有力形成了“需求->开发->集成->测试->部署”的可持续的反馈闭环。
   
   #### 什么是持续交付流水线
   
   在交付过程中，持续集成服务器将把开发部署过程中的各个闭环衔接起来，组成一个自动化的持续交付流水线，作为整个交付过程的协调中枢。
   
   典型的持续交付流水线中，大致会经历构建自动化和持续集成、测试自动化和部署自动化等阶段。
   
   1. 自动化构建和持续集成
   2. 自动化测试
   3. 自动化部署
   
   #### 持续交付流水线的最佳实践
   
   1. 做好配置管理
   2. 合理编排流水线
   3. 不要添加新的功能，知道通过质量测试
   
   #### 配置管理
   
   1. 什么是配置管理
   
      配置管理是指一个过程，通过该过程，将所有与项目相关的产物，以及它们之间的关系都被唯一定义、修改、存储和检索。
   
      配置管理是软件开发过程中极其重要的一部分，持续集成、部署流水线、自动化测试等，若想真正发挥好作用，都必须做好配置管理工作。
   
   2. 如何进行配置管理
   
      * 版本控制
      * 依赖管理
      * 软件配置管理
      * 环境配置管理
   
   #### 持续交付与DevOps
   
   DevOps是Development与Operations的缩写，DevOps推动了一套用于思考沟通和谐做得过程和方法，用于促进开发、技术运营和质保部门之间的沟通、协作与整合，其推崇的团队将会是一个结合开发、质量保证（QA）、IT运营等整个职责的跨职能团队。
   
   持续交付和DevOps在其意义上及目标上是相似的（旨在快速交付产品），但它们是两个不同的概念。
   
   DevOps有更广泛的范围、围绕：组织变革，具体来说，支持参与软件交付的各类人员之间的更大的协作，包括开发、运营、质保、管理等；自动化软件交付过程。
   
   持续交付是一种自动化交付软件的方法，并且侧重于：结合不同的过程，包括开发、继承、测试、部署等；更快、更频繁地执行上述过程。
   
   ### 基于容器的部署与发布微服务
   
   容器提供了一种将所有的服务能够迅速快捷地重新部署的方案，并且可以根据需要进行横向的扩展，且保证高可用性，再出现问题的时候可以自动重启或启动备份服务。
   
   #### 虚拟化技术
   
   所谓虚拟化技术就是将事物从一种形式转变为另一种形式，最常用的虚拟化技术有操作系统中内存的虚拟化，实际运行时用户需要的内存空间可能远远大于物理机器的内存大小，利用内存的虚拟化技术，用户可以将一部分硬盘虚拟化为内存，而这对用户是透明的 。
   
   虚拟机技术是虚拟化技术的一种，通常的使用模式是分时共享昂贵的大型极。
   
   #### 容器和虚拟机
   
   容器具有轻量级特性，所需的内存空间较少，提供非常快的启动速度，而虚拟机提供了专用操作系统的安全性和更牢固的逻辑边界。如果是虚拟机，虚拟管理程序与硬件对话，就如同虚拟机的操作系统和应用程序构成了一个单独的物理机。虚拟机中的操作系统可以完全不同于主机的操作系统。
   
   容器提供了更高级的隔离机制，许多应用程序在主机操作系统下运行，所有应用程序共享某些操作系统库和操作系统的内核。
   
   容器的一大好处就是应用程序以标准方式进行了格式化之后才放到容器中，开发人员可以使用同样的工具和工作流程，不管目标操作系统是什么。一旦在容器中，每种类型的应用程序都是以同样地方式在网络上移动。
   
   1. 成熟度方面的比较
   2. 启动速度的比较
   3. 安全方面的比较
   4. 性能方面的比较
   
   #### 基于容器的持续部署流程
   
   1. 建立持续部署流水线
   2. 测试
   3. 构建
   4. 部署
   5. 蓝-绿部署
   6. 运行预集成及集成后测试
   7. 回滚和清理
   8. 决定每个步骤的执行环境
   9. 完成整个持续部署流
   
   ### 使用Docker来构建、运行、发布微服务
   
   #### Docker的安装
   
   1. 下载安装Docker
   
      [下载地址](https://docs.docker.com/docker-for-windows/install/#download-docker-for-windows)
   
   2. 验证安装
   
   #### Docker的简单使用
   
   1. 查看容器列表
   
      ```bash
      $docker ps
      ```
   
      
   
   2. 查看Docker的版本信息
   
      ```bash
      $docker version
      ```
   
      
   
   3. 查看Docker的详细信息
   
      ```bash
      $docker info
      ```
   
      
   
   4. 运行容器
   
      ```bash
      $docker run hello-world
      ```
   
      
   
   #### Docker运行微服务
   
   1. 创建微服务
   
   2. 微服务容器化
   
      在应用的根目录下创建Dockerfile文件。
   
      ```dockerfile
      FROM openjdk:8-jdk-alpine
      VOLUME /tmp
      ARG JAR_FILE
      ADD ${JAR_FILE} app.jar
      ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
      ```
   
      * FROM可以理解为我们这个image依赖于另一个image。
      * 项目JAR文件以“app.jar”的形式添加到容器中，然后在ENTRYPOINT中执行。
      * VOLUME指定了临时文件目录为/tmp。其效果是在主机/var/lib/docker目录下创建了一个临时文件，并链接到容器的/tmp。该步骤是可选的，如果涉及文件系统的应用，就很有必要了。/tmp目录用来持久化到Docker数据文件夹，因为Spring Boot使用的内嵌Tomcat容器默认使用/tmp作为工作目录。
      * 为了缩短Tomcat启动时间，添加一个系统属性指向/dev/./urandom。
   
   3. 使用Gradle来构建Docker image
   
      为了使用Gradle来构建Docker image，需要添加docker插件在应用的build.gradel中。
   
      ```groovy
      buildscript {
          ...
              dependencies {
                  ...
                  classpath('com.palantir.gradle.docker:gradle-docker:0.17.2')
              }
      }
      ...
      apply plugin: 'com.palantir.docker'
      docker {
          name "${project.group}/${jar.baseName}"
          file jar.archivePath
          buildArgs(['JAR_FILE': "${jar.archiveName}"])
      }
      ```
   
      执行gradlew build docker来构建Docker image。
   
      ```bash
      $gradlew build docker --info
      ```
   
      
   
   4. 运行image
   
      在构建Docker image完成之后，使用Docker来运行image。
   
      ```bash
      $docker run -p 8080:8080 -t com.waylau.spring.cloud/hello-world-docker
      ```
   
      
   
   5. 访问应用
   
      image运行成功后，通过浏览器访问http://localhost:8080/hello即可。
   
   6. 关闭容器
   
      可以先通过docker ps命令来查看正在运行的容器ID，而后可移植性docker stop命令来关闭容器。
   
   #### Docker发布微服务
   
   当我们的微服务包装成为了Docker image之后，就能进行分发了。用户可以将自己的image推送到Docker Hub上，以方便其他人下载。
   
   #### Docker展望
   
   ## 微服务的日志与监控
   
   ### 微服务日志管理将面临的挑战
   
   日志是应用里面不可或缺的非常重要的组成部分。特别是对于运维人员来说，日志是排除问题、解决问题的关键。
   
   日志来自正在运行的进程的事件流。
   
   日志处理的最佳实践之一是关闭生产中的大部分日志条目，因为磁盘IO的成本很高。磁盘IO不但会减慢应用程序的运行速度，还会严重影响它的可伸缩性。将日志写入磁盘也需要较高的磁盘容量。当磁盘空间用完之后，就有可能降低应用程序的性能。日志框架提供了在运行时控制日志记录的选项，以限制必须打印及不打印的内容。
   
   另外，日志可能包含重要的信息，如果分析得当，则可能具有很高的价值。因此，限制日志条目本质上限制了用户解决应用程序行为的能力。
   
   #### 日志文件分散
   
   微服务架构锁带来的直观结果，就是为服务实例数量的增长，伴随而来的就是日志文件的递增。
   
   在微服务架构里，每个微服务实例都是独立部署的，日志文件分散在不同的主机里。如果还是按照传统的运维方式，登录到应用程序所在的主机来查看日志文件，这种方式基本上不可能在微服务架构中使用。
   
   #### 日志容易丢失
   
   从传统部署移到云部署时，应用程序不再锁定到特定的预定机器。虚拟机和容器应用程序之间没有强制的关联关系，这意味着用于部署的机器可能会随时更改。特别像是Docker这样的容器，通常来说都是非常短暂的，这基本上意味着不能依赖磁盘的持久状态。一旦容器停止并重新启动，写入磁盘的日志文件将会丢失，所以不能依靠本地机器的磁盘来记录日志文件。
   
   #### 事务跨越了多个服务
   
   在微服务架构中，微服务实例将运行在孤立的物理或虚拟机上。在这种情况下，阆中多个微服务的端到端事务几乎是不可能的。
   
   微服务实例在不同的机器上，因此很难实现服务级别的日志聚合，最终导致了日志文件的碎片化。
   
   ### 日志集中化的意义
   
   日志管理解决方案，需要考虑的功能：
   
   * 能够收集所有日志消息并在日志消息之上运行分析。
   * 能够关联和跟踪端到端的事务。
   * 能够保存更长时间的日志信息，以便进行趋势分析和预测。
   * 能够消除对本地磁盘系统的依赖。
   * 能够聚合来自多个来源的日志信息，如网络设备、操作系统、微服务等。
   
   解决这些问题的方法是集中存储和分析所有的日志消息，而不考虑日志的来源。
   
   在集中式日志解决方案，日志消息将从执行环境发送到中央大数据存储。日志分析和处理将使用大数据解决方案进行处理。
   
   #### 集中化日志管理的系统架构
   
   集中化日志管理系统包含的组件：
   
   * 日志流：
   * 日志托运
   * 日志存储
   * 日志流处理器
   * 日志仪表板
   
   #### 集中化日志管理的意义
   
   集中化日志管理的好处不仅没有本地IO或阻塞磁盘写入，也没有使用本地机器的磁盘空间。这种架构用于大数据处理的Lambda架构基本相似。
   
   同时，每条日志信息都包含了上下文及相关ID。上下文通常会有时间戳、IP地址、用户信息、日志类型等。
   
   ### 常见的日志集中化的实现方式
   
   #### 日志托运
   
   不同的日志托运工具的功能不同：
   
   * Logstash：
   * Fluented：
   
   #### 日志存储
   
   实时日志消息通常存储在Elasticsearch中，它允许客户端根据基于文本的索引进行查询。除了Elasticsearch外，HDFS还常用于存储归档的日志消息。MongoDB或Cassandra用于存储汇总数据。
   
   脱机日志处理可以使用Hadoop的map reduce程序完成。
   
   #### 日志流处理器
   
   日志处理器可用于处理日志流。
   
   日志处理器的典型架构是将Fluent和Kafka结合在一起，并在Storm或Spark Streaming结合使用。Log4j有Flume appender，可用于收集日志消息。这些消息将被推送到分布式Kafka消息队列中。流处理器从Kafka收集数据，并在发送给Elasticsearch和其他日志存储之前进行处理。
   
   Spring Cloud Stream和Spring Cloud Data Flow可用于构建日志流处理器。
   
   #### 日志仪表板
   
   日志分析最常用的仪表板是使用Elasticsearch数据存储的Kibana。
   
   Graphite和Grafana也被用来显式日志分析报告。
   
   ### Elastic Stack实现日志集中化
   
   #### Elasticsearch的安装和使用
   
   1. 下载Elasticsearch，下载地址为https://www.elastic.co/cn/downloads/Elasticsearch
   2. 解压。
   3. 运行。
   4. 访问。网址为http://localhost:9200/
   
   #### Kibana的安装和使用
   
   1. 下载Kibana，下载地址为https://www.elastic.co/cn/downloads/Kibana
   2. 解压。
   3. 运行。
   4. 访问。网址为http://localhost:5601/
   
   #### Logstash的安装和使用
   
   1. 下载Logstash，下载地址为https://www.elastic.co/cn/downloads/Logstash
   2. 解压。
   3. 运行。
   
   #### 综合示例演示
   
   1. 创建hello-world-log
   
   2. 添加Logback JSON编码器
   
      ```groovy
      dependencies {
          //...
          compile('net.logstash.logback:logstash-logback-encoder:4.11')
      }
      ```
   
      
   
   3. 添加logback.xml
   
      在应用的src/main/resources目录下，创建logback.xml文件
   
      ```xml
      <?xml version="1.0" encoding="UTF-8"?>
      <configuration>
          <include resource="org/springframework/boot/logging/logback/defaults.xml"/>
          <include resource="org/springframework/boot/logging/logback/console-appender.xml"/>
          <appender name="stash" class="net.logstash.logback.appender.LogstashTcpSocketAppender">
              <destination>localhost:4560</destination>
              <encoder class="net.logstash.logback.encoder.LogstashEncoder"/>
          </appender>
          <root level="INFO">
              <appender-ref ref="CONSOLE"/>
              <appender-ref ref="stash"/>
          </root>
      </configuration>
      ```
   
      
   
   4. 创建logstash.conf
   
      在Logstash的bin目录下，创建logstash.conf文件，用于配置Logstash
   
      ```tex
      input {
      	tcp {
      		port => 4560
      		host => localhost
      	}
      }
      output {
      	elasticsearch { hosts => ["locahost:9200"] }
      	stdout { codec => rubydebug }
      }
      ```
   
      
   
   5. 启动Elastic Stack
   
      按以下顺序执行命令来启动Elastic Stack。
   
      ```bash
      .\bin\elasticsearch
      .\bin\kibana
      .\bin\logstash -f logstash.conf
      ```
   
      
   
   6. 启动hello-world-log
   
   7. Kibana分析日志
   
   #### 集中式日志管理系统的展望
   
   ## 微服务的集中化配置
   
   ### 为什么需要集中化配置
   
   #### 配置分类
   
   1. 按配置的来源划分
   2. 按适用的环境划分
   3. 按配置的集成阶段划分
   4. 按配置的加载方式划分
   
   #### 配置中心的需求
   
   #### Spring Cloud Config
   
   ### 使用Config实现的配置中心
   
   #### 开发环境
   
   #### 创建配置中心的服务端
   
   #### 创建配置中心的客户端
   
   #### 如何测试
   
   ## 微服务的高级主题——自动扩展
   
   ### 自动扩展的定义
   
   #### 自我注册和自我发现
   
   #### 自我扩展的核心概念
   
   ### 自动扩展的意义
   
   ### 自动扩展的常见模式
   
   #### 自动扩展的不同级别
   
   #### 自动扩展的常用方法
   
   ### 如何实现微服务的自动扩展
   
   #### 容器编排
   
   #### 常用的容器编排技术
   
   ## 微服务的高级主题——熔断机制
   
   ### 什么是服务的熔断机制
   
   #### 服务熔断的定义
   
   #### 断路器
   
   #### 断路器模式
   
   ### 熔断的意义
   
   #### 断路器模式所带来的好处
   
   #### 断路器模式的功能
   
   ### 熔断与降级的区别
   
   #### 熔断与降级的相似点
   
   #### 熔断与降级的区别
   
   ### 如何集成Hystrix
   
   #### 所需环境
   
   #### 更改配置
   
   #### 使用Hystrix
   
   #### 增加断路器
   
   #### 修改应用配置
   
   #### 运行、测试
   
   ### 实现微服务的熔断机制
   
   #### 更改配置
   
   #### 使用Hystrix
   
   #### 实现断路器
   
   #### 修改report.html页面
   
   #### 修改应用配置
   
   #### 运行、测试
   
   ## 微服务的高级主题——分布式消息总线
   
   ### 消息总线的定义
   
   #### 消息总线常见的设计模式
   
   #### 消息总线的意义
   
   #### 消息总线常见的实现方式
   
   #### Spring Cloud Bus实现消息总线
   
   ### Spring Cloud Bus设计原理
   
   #### 基于Spring Cloud Stream
   
   #### Spring Cloud Bus的编程模型
   
   ### 如何集成Bus
   
   #### 初始化应用
   
   #### 所需环境
   
   #### 更改配置
   
   #### 下载安装RabbitMQ
   
   #### 修改micro-weather-config-client-bus
   
   #### 运行、测试
   
   ### 实现配置信息的自动更新
   
   #### 刷新配置信息
   
   #### 实现配置信息的自动更新
   
   #### 使用ngrok进行本地测试
   
   