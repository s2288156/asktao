# mall-micro

#### 介绍
商城oauth2，微服务实现方案

#### 软件架构
软件架构说明

![](https://app.yinxiang.com/FileSharing.action?hash=1/491d7a3072406accbac9992d67aa85ef-347581)

#### 安装教程

1.  xxxx
2.  xxxx
3.  xxxx

#### 使用说明

1. 获取jwt，`localhost:8200/auth/oauth/token`接口为框架实现，可以参考TokenEndpoint中的代码，参数：
    - grant_type(必传): password - 密码模式; refresh_token - 刷新access_token; authorization_code - 授权码模式; client_credentials; implicit;
    - client_id(必传): Oauth2ServerConfig中配置
    - client_secret(必传): Oauth2ServerConfig中配置
    - username: 用户名，数据库存储t_member表或t_manager表
    - password: 密码，数据库存储t_member表或t_manager表
    - refresh_token: 刷新token

#### 命名规范

| 规范 | 用途 | 解释 |
| --- | --- | --- |
| xxxCmd.java | Client Request | Cmd代表Command，标识一个用户请求 |
| xxxCO.java | Client Object | 客户对象，用于传输数据，等同于DTO |
| IxxxServce.java | API Service | API接口类 |
| xxxCmdExe.java | Command Executor | 命令模式，每一个用户请求对应一个执行器 |
| xxxInterceptor.java | Command Interceptor | 拦截器，用户处理切面逻辑 |
| xxxExtPt.java | ExtensionPoint | 扩展点 |
| xxxExt.java | Extention | 扩展实现 |
| xxxValidator.java | Validator | 校验器，用户校验的类 |
| xxxConvertor.java | Convertor | 转化器，实现不同层级对象互转 |
| xxxAssembler.java | Assembler | 组装器，组装外部服务调用参数 |
| xxxE.java | Entity | 领域实体 |
| xxxV.java | Value Object | 值对象 |
| xxxRepository.java | Repository | 仓储接口 |
| xxxDomainService.java | Domain Service | 领域服务 |
| xxxDO.java | Data Object | 数据对象，用于持久化 |
| xxxTunnel.java | Data Tunnel | 数据通道，DAO是最常见的通道，也可以是其它通道 |
| xxxConstant.java | Constant Class | 常量类 |
| xxxConfig.java | Configuration class | 配置类 |
| xxxUtil.java | Utility class | 工具类（尽量少使用util的命名，太通用，不够显性化） |

#### 参与贡献

1.  Fork 本仓库
2.  新建 Feat_xxx 分支
3.  提交代码
4.  新建 Pull Request


