package ir.mhe47880.coffeeshopapp.ui.navigation.navutils

fun routeWithArgs(vararg args: String, route: String) =

    buildString {
        append(route)
        args.forEachIndexed { index, _ ->
            append("?$index={$index}")
        }
    }


fun paramsWithArgs(vararg args: String, route: String) =

    buildString {
        append(route)
        args.forEachIndexed { index, value ->
            append("?$index=$value")
        }
    }

//Todo