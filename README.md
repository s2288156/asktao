# mall-micro

#### 介绍
商城oauth2，微服务实现方案

#### 软件架构
软件架构说明


#### 安装教程

1.  xxxx
2.  xxxx
3.  xxxx

#### 使用说明

1. 获取jwt，`localhost:8200/auth/oauth/token`接口为框架实现，可以参考TokenEndpoint中的代码，参数：
    - grant_type: password - 密码模式; refresh_token - 刷新access_token; authorization_code - 授权码模式; client_credentials; implicit;
    - client_id: Oauth2ServerConfig中配置
    - client_secret: Oauth2ServerConfig中配置
    - username: 用户名，数据库存储t_member表或t_manager表
    - password: 密码，数据库存储t_member表或t_manager表

#### 参与贡献

1.  Fork 本仓库
2.  新建 Feat_xxx 分支
3.  提交代码
4.  新建 Pull Request


