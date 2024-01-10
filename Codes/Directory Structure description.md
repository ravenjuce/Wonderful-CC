

1. **assets:** All the files that need to be put into assets directory of the project should be put in this directory. Try not to put them into assets of other Modules (such as Base and Thirslib), so as to facilitate unified management.

2. **activity:** BaseActivity and activities unrelated to the project business will be placed in the root directory of the package, and other activities related to the project business will be placed in the new subpackage directory named after the business name. If the project is simple, it will be placed in the normal directory.

3. **adapter:**  Collection of adapter class collection

4. **bean:** Collection of entity classes

5. **dialog:** BaseDialogFragment will be placed in the root directory of the package, and other dialog related to the project business will be placed in the newly created sub-package directory named after the business name. If the project is simple, it will be placed in the normal directory.

6. **enumtype:** Collection of enum classed

7. **fragment:** The BaseFragment is stored in the root directory of the package. Other fragments related to the project business are stored in the newly created subpackage directory named after the service name. If the project is simple, the fragment is stored in the normal directory.

8. **listener:** Collection of listener classes

9. **mvp:** Root directory for MVP mode

- **mvp/iview:** View

- **mvp/model:** Model

- **mvp/presenter:** Presenter

10. **utils:** A collection of common utility classes

11. **views:** Custom View collection  

12. **MyApplication.java:** The custom Application class for the project declaration (note: all methods in the project that need to be declared in the custom Application, such as some configurations when introducing third-party platforms, need to be written here)


---





Translation:

1 **assets目录** 项目中需要放到assets目录的文件都放到这里，尽量不放到其他module的assets中(比如base、thirslib)，这样便于统一管理。

> res目录下的，是可编译的资源文件，可以通过R.xxx.id访问
> 但assets目录中存放的，是不能被编译的、原生的资源文件。存在于apk中。因为apk安装之后会放在/data/app/**.apk目录下，以apk形式存在，asset被绑定在apk里，并不会解压到/data/data/YourApp目录下去，所以我们无法直接获取到assets的绝对路径，因为它们根本就没有。

2 **activity目录** BaseActivity和与项目业务无关的activity放到包的根目录下，其他与项目业务相关的activity放到新建的以业务名称命名的子包目录下，如果项目比较简单，那么就统一放到normal目录下即可。

3 **adapter目录** 适配器类集合

4 **bean目录：** 实体类集合

5 **dialog目录** BaseDialogFragment放到包的根目录下，其他与项目业务相关的dialog放到新建的以业务名称命名的子包目录下，如果项目比较简单，那么就统一放到normal目录下即可。

6 **enumtype目录** 枚举类集合

7 **fragment目录** BaseFragment放到包的根目录下，其他与项目业务相关的fragment放到新建的以业务名称命名的子包目录下，如果项目比较简单，那么就统一放到normal目录下即可。

8 **listener目录** 监听器类集合

9 **mvp目录** mvp模式的根目录

- **mvp/iview目录** mvp模式中的V

- **mvp/model目录** mvp模式中的M

- **mvp/presenter目录** mvp模式中的P

10 **utils目录** 常用工具类集合(注意，区别base中的utils目录，这里是仅在app中用到的工具类，不是通用工具类集合，通用工具类集合在base/utils目录中)

11**views目录** 自定义view集合(注意，区别base中的views目录，这里是仅在app中用到的自定义view，不是通用自定义view集合，通用自定义view集合在base/views目录中)

12 **MyApplication.java文件** 项目声明的自定义Application类(注意：项目中所有需要在自定义Application中声明的方法，比如引入第三方平台时一些配置，都需要写在这里)













