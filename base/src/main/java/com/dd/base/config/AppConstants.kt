package com.dd.base.config

/**
* @Date 2020/10/22
 * @Description 常量管理类
 */
interface AppConstants {
    object SpKey {
        const val FOLLOW_SYSTEM: String = "follow_system"//跟随系统
        const val NIGHT_MODE: String = "night_mode"//夜间模式
    }

    object CacheKey{
        // 缓存有效期时长1天 数据刷新会重新刷新时长
        const val CACHE_SAVE_TIME_SECONDS = 86400
        const val CACHE_HOME_BANNER = "cache_home_banner"
        const val CACHE_HOME_ARTICLE = "cache_home_article"
        const val CACHE_HOME_KEYWORD = "cache_home_keyword"
        const val CACHE_SQUARE_LIST = "cache_square_list"
        const val CACHE_PROJECT_SORT = "cache_project_sort"
        const val CACHE_PROJECT_CONTENT = "cache_project_content"
    }

    /**
     * value规则： /(module后缀)/(所在类名)
     * 路由 A_ : Activity
     *     F_ : Fragment
     */
    interface Router {

        object Main {
            const val A_MAIN = "/main/MainActivity"
            const val A_TEST = "/main/TestActivity"
            const val A_DIALOG = "/main/DialogActivity"
            const val A_RECYCLER = "/main/RecycleActivity"
            const val A_EVENT = "/main/EventBusActivity"
            const val A_TOAST = "/main/ToastActivity"
            const val A_NIGHT = "/main/ToastActivity"
        }
    }
}