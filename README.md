VirtualHook
-----------

## Introduction 

VirtualHook is a tool for hooking application without root permission. It is based on two projects:

- [VirtualApp](https://github.com/asLody/VirtualApp). It's a plugin framework which allows running applications in its virtual space.
- [YAHFA](https://github.com/rk700/YAHFA). It's a hook framework for ART which allows hooking Java method of the application.

Currently VirtualHook supports:

- Android 5.0(API 21)
- Android 5.1(API 22)
- Android 6.0(API 23)
- __EXPERIMENTAL__ Android 7.0(API 24)
- __EXPERIMENTAL__ Android 7.1(API 25)

## Build

Import and build the project in Android Studio(__with Instant Run disabled__). There are four modules:

- `app`. This is the VirtualApp application module.
- `lib`. This is the VirtualApp library module.
- `YAHFA`. This is the YAHFA hook module.
- `demoHookPlugin`. This is a demo hook plugin which compiles to an APK.

After building the APKs, push the `demoHookPlugin` APK to device in folder `/sdcard/io.virtualhook/` and run the main application. All plugin APKs in `/sdcard/io.virtualhook` would be applied to applications running in VirtualHook.

Please refer to [demoHookPlugin](https://github.com/rk700/VirtualHook/tree/master/VirtualApp/demoHookPlugin) for more details.

## Hooking Native Methods

VirtualApp comes with native method hooking ability in the first place, which is done with the following function:

```cpp
namespace Cydia{
    void MSHookFunction(void *symbol, void *replace, void **result);
}
```

To utilize that, you can use `dlsym()` to find the symbol and then hook your targets. Here's a [demo](https://github.com/rk700/ChangePhoneInfo/blob/master/app/src/main/jni/hookprop.c) which hooks `__system_property_get`.

## Example Hook Plugins

- [CertUnpinning](https://github.com/rk700/CertUnpinning): HTTPS certificate unpinning.
- [ChangePhoneInfo](https://github.com/rk700/ChangePhoneInfo): Change device information.

## License

Both VirtualApp and YAHFA are distributed under GNU GPL V3.
