package com.belia.speedotransfer.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.belia.speedotransfer.navigation.AppRoutes.CHANGEPASSWORD
import com.belia.speedotransfer.navigation.AppRoutes.CONFIRMATION
import com.belia.speedotransfer.navigation.AppRoutes.EDITPROFILE
import com.belia.speedotransfer.navigation.AppRoutes.FAVOURITES
import com.belia.speedotransfer.navigation.AppRoutes.HOME
import com.belia.speedotransfer.navigation.AppRoutes.LOGIN
import com.belia.speedotransfer.navigation.AppRoutes.MORE
import com.belia.speedotransfer.navigation.AppRoutes.MYCARDS
import com.belia.speedotransfer.navigation.AppRoutes.NOTIFICATIONS
import com.belia.speedotransfer.navigation.AppRoutes.ONBOARDING
import com.belia.speedotransfer.navigation.AppRoutes.PAYMENT
import com.belia.speedotransfer.navigation.AppRoutes.PROFILE
import com.belia.speedotransfer.navigation.AppRoutes.PROFILEINFO
import com.belia.speedotransfer.navigation.AppRoutes.SECONDSIGNUP
import com.belia.speedotransfer.navigation.AppRoutes.SETTINGS
import com.belia.speedotransfer.navigation.AppRoutes.SIGNUP
import com.belia.speedotransfer.navigation.AppRoutes.SPLASH
import com.belia.speedotransfer.navigation.AppRoutes.TRANSACTIONITEM
import com.belia.speedotransfer.navigation.AppRoutes.TRANSACTIONS
import com.belia.speedotransfer.navigation.AppRoutes.TRANSFER
import com.belia.speedotransfer.ui.auth.Login
import com.belia.speedotransfer.ui.auth.SecondSignUp
import com.belia.speedotransfer.ui.auth.SignUp
import com.belia.speedotransfer.ui.main_screens.home_screen.HomePage
import com.belia.speedotransfer.ui.main_screens.more.MoreScreen
import com.belia.speedotransfer.ui.main_screens.more.favourites.FavouriteScreen
import com.belia.speedotransfer.ui.main_screens.more.profile.profile_screen.ProfileInfo
import com.belia.speedotransfer.ui.main_screens.more.profile.profile_screen.ProfileScreen
import com.belia.speedotransfer.ui.main_screens.more.profile.settings.ChangePasswordScreen
import com.belia.speedotransfer.ui.main_screens.more.profile.settings.EditProfileScreen
import com.belia.speedotransfer.ui.main_screens.more.profile.settings.SettingsScreen
import com.belia.speedotransfer.ui.main_screens.my_cards.MyCardsScreen
import com.belia.speedotransfer.ui.main_screens.notifitcation_screen.NotificationScreen
import com.belia.speedotransfer.ui.main_screens.transactions_screen.last_transcations.LastTransactions
import com.belia.speedotransfer.ui.main_screens.transactions_screen.transaction.Transaction
import com.belia.speedotransfer.ui.main_screens.transfer_screen.amount_screen.AmountScreen
import com.belia.speedotransfer.ui.main_screens.transfer_screen.confirmation_screen.ConfirmationScreen
import com.belia.speedotransfer.ui.main_screens.transfer_screen.payment_screen.PaymentScreen
import com.belia.speedotransfer.ui.onboarding_screen.OnboardingScreen
import com.belia.speedotransfer.ui.splash_screen.SplashScreen
import com.belia.speedotransfer.viewmodels.SharedViewModel

object AppRoutes {
    const val SPLASH = "splash"
    const val LOGIN = "login"
    const val SIGNUP = "signup"
    const val SECONDSIGNUP = "secondsignup"
    const val HOME = "home"
    const val TRANSFER = "transfer"
    const val TRANSACTIONS = "transactions"
    const val MORE = "more"
    const val CONFIRMATION = "confirmation"
    const val PAYMENT = "payment"
    const val FAVOURITES = "favourites"
    const val ONBOARDING = "ondoarding"
    const val PROFILE = "profile"
    const val PROFILEINFO = "profileinfo"
    const val SETTINGS = "settings"
    const val CHANGEPASSWORD = "changepassword"
    const val EDITPROFILE = "editprofile"
    const val TRANSACTIONITEM = "transactionitem"
    const val NOTIFICATIONS = "notifications"
    const val MYCARDS = "mycards"
}

@Composable
fun AppNavHost(modifier: Modifier = Modifier, context: Context) {
    val navController = rememberNavController()
    val sharedViewModel = SharedViewModel()
    NavHost(
        navController = navController,
        startDestination = SPLASH
    ) {
        composable(route = SPLASH) { SplashScreen(navController, context) }
        composable(route = ONBOARDING) { OnboardingScreen(navController) }
        composable(route = LOGIN) { Login(navController, sharedViewModel) }
        composable(route = SIGNUP) { SignUp(navController) }
        composable(route = SECONDSIGNUP) { SecondSignUp(navController) }
        composable(route = HOME) { HomePage(navController, sharedViewModel) }
        composable(route = TRANSFER) { AmountScreen(navController, sharedViewModel) }
        composable(route = TRANSACTIONS) { LastTransactions(navController, sharedViewModel) }
        composable(route = MORE) { MoreScreen(navController) }
        composable(
            route = "$CONFIRMATION/{amount}/{name}/{account}",
            arguments = listOf(
                navArgument("amount") { type = NavType.FloatType },
                navArgument("name") { type = NavType.StringType },
                navArgument("account") { type = NavType.StringType }
            )
        ) {
            val amount = it.arguments?.getFloat("amount") ?: 0f
            val name = it.arguments?.getString("name") ?: ""
            val account = it.arguments?.getString("account") ?: ""
            ConfirmationScreen(amount, name, account, navController = navController, sharedViewModel)
        }
        composable(
            route = "$PAYMENT/{amount}/{name}/{account}",
            arguments = listOf(
                navArgument("amount") { type = NavType.FloatType },
                navArgument("name") { type = NavType.StringType },
                navArgument("account") { type = NavType.StringType }
            )
        ) {
            val amount = it.arguments?.getFloat("amount") ?: 0f
            val name = it.arguments?.getString("name") ?: ""
            val account = it.arguments?.getString("account") ?: ""
            PaymentScreen(amount, name, account, navController = navController, sharedViewModel)
        }
        composable(route = FAVOURITES) { FavouriteScreen(navController, sharedViewModel) }
        composable(route = PROFILE) { ProfileScreen(navController, sharedViewModel) }
        composable(route = PROFILEINFO) { ProfileInfo(navController, sharedViewModel) }
        composable(route = SETTINGS) { SettingsScreen(navController) }
        composable(route = CHANGEPASSWORD) { ChangePasswordScreen(navController, sharedViewModel) }
        composable(route = EDITPROFILE) { EditProfileScreen(navController, sharedViewModel) }
        composable(
            route = "$TRANSACTIONITEM/{index}",
            arguments = listOf(
                navArgument("index") { type = NavType.IntType }
            )
        ) {
            val index = it.arguments?.getInt("index") ?: 0
            Transaction(navController, sharedViewModel, index)
        }
        composable(route = NOTIFICATIONS) { NotificationScreen(navController, sharedViewModel) }
        composable(route = MYCARDS) { MyCardsScreen(navController, sharedViewModel) }
    }
}