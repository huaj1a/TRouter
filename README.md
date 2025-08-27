<img width="200" height="100" alt="TRouter" src="https://github.com/user-attachments/assets/03904412-5253-4ed0-84a1-d82624cafbf0" />


```
    A framework for Android modal dialog
```

---

#### Demo
[Gif](https://github.com/huaj1a/TRouter/blob/master/demo/TRouter-demo.gif)

#### Lastest version

module|trouter-api|trouter-compiler|trouter-annotation
---|---|---|---|
version|[![Download](https://img.shields.io/maven-central/v/io.github.huaj1a/trouter-api)](https://central.sonatype.com/artifact/io.github.huaj1a/trouter-api)|[![Download](https://img.shields.io/maven-central/v/io.github.huaj1a/trouter-compiler)](https://central.sonatype.com/artifact/io.github.huaj1a/trouter-compiler)|[![Download](https://img.shields.io/maven-central/v/io.github.huaj1a/trouter-annotation)](https://central.sonatype.com/artifact/io.github.huaj1a/trouter-annotation)
version-log|[api-log](https://github.com/huaj1a/TRouter/blob/master/trouter-api/version_log.md)|[compiler-log](https://github.com/huaj1a/TRouter/blob/master/trouter-compiler/version_log.md)|[annotation-log](https://github.com/huaj1a/TRouter/blob/master/trouter-annotation/version_log.md)

#### I. Feature
1. Support for multi-module
2. Support parameter passing
3. Support window drag
4. Support multiple ways to configure transition animation and custom animation
5. …………

#### II. Configuration
1. Adding dependencies and configurations
    ``` gradle
    android {
        ...
        kapt {
            arguments {
                arg("TROUTER_MODULE_NAME", project.name)
            }
        }
    }

    dependencies {
        // Replace with the latest version
        implementation 'io.github.huaj1a:trouter-api:?'
        kapt 'io.github.huaj1a:trouter-compiler:?'
        ...
    }
    ```
    
2. Add annotations
    ``` java
    // Add annotations on pages that support routing (required)
    // The path here needs to pay attention to need at least two levels : /xx/xx
    @Route(
        path = "/dialog/BasicComposeDialog",
        height = 0.5f,
        width = 0.75f
    )
    class BasicComposeDialog(context: Context): BaseComposeModalDialog(context) {
       ……
    }
    ```

3. Initialize the SDK
    ``` java
    if (isDebug()) {
        TRouter.openLog()
    }
    TRouter.getInstance().init(activity)
    ```

4. Initiate the routing
   ``` kotlin
   TRouter.getInstance()
          .build("/dialog/BasicComposeDialog")
          .withModalType(ModalType.MODAL)
          .navigation()

   TRouter.getInstance()
          .build(BundleDialogPath)
          .withBundle(BundleDialog.KEY_INT, 123456)
          .withBundle(BundleDialog.KEY_FLOAT, 3.14159f)
          .withBundle(BundleDialog.KEY_TIME, System.currentTimeMillis())
          .withBundle(BundleDialog.KEY_STRING, "Hello TRouter")
          .withBundle(BundleDialog.KEY_LIST_INT, listOf(1, 3, 5))
          .withBundle(BundleDialog.KEY_LIST_STRING, listOf("apple", "banana", "orange"))
          .withBundle(BundleDialog.KEY_OBJECT, 
              BundleTest(654321, 
                         1.2345f, 
                         System.currentTimeMillis(), 
                         "Hello Android", 
                          listOf(2, 4, 6),
                          listOf("java", "kotlin", "c++")
                        ))
            .navigation()
   
   ```

5. Add confusing rules (If Proguard is turn on)
   ```
   
   ```
---

#### The ending
thanks for [ARouter](https://github.com/alibaba/ARouter)。

Maybe not a production framework, but I hope it's something fun

light up star ～
