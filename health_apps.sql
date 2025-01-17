-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 17, 2025 at 12:16 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `health_apps`
--

-- --------------------------------------------------------

--
-- Table structure for table `kegiatan`
--

CREATE TABLE `kegiatan` (
  `username` varchar(50) DEFAULT NULL,
  `nama_kegiatan` varchar(50) DEFAULT NULL,
  `jenis_kegiatan` enum('Olahraga','Makan Pagi','Meeting') DEFAULT NULL,
  `tanggal_waktu` datetime DEFAULT NULL,
  `pengingat` time DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `kegiatan`
--

INSERT INTO `kegiatan` (`username`, `nama_kegiatan`, `jenis_kegiatan`, `tanggal_waktu`, `pengingat`) VALUES
('admin', 'GYM', 'Olahraga', '2025-01-01 07:00:00', '06:30:00');

-- --------------------------------------------------------

--
-- Table structure for table `penyakit`
--

CREATE TABLE `penyakit` (
  `gambar` varchar(255) NOT NULL,
  `jenis_penyakit` char(50) NOT NULL,
  `pengertian` varchar(1000) NOT NULL,
  `gejala` varchar(500) NOT NULL,
  `pengobatan` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `penyakit`
--

INSERT INTO `penyakit` (`gambar`, `jenis_penyakit`, `pengertian`, `gejala`, `pengobatan`) VALUES
('penyakit_2.png', 'ADHD', 'ADHD atau Attention Deficit Hyperactivity Disorder adalah gangguan neurobiologis yang ditandai dengan kesulitan mempertahankan perhatian, hiperaktivitas, dan impulsivitas.', 'Sulit fokus, mudah teralihkan, impulsif, gelisah, sering lupa, dan kesulitan mengatur waktu.', 'Pengobatan ADHD meliputi terapi perilaku, obat stimulan atau non-stimulan, dan manajemen pola hidup seperti rutinitas terstruktur dan olahraga.'),
('penyakit_6.png', 'Anxiety', 'Anxiety adalah perasaan cemas berlebihan yang ditandai dengan gelisah, tegang, sulit fokus, detak jantung cepat, dan gangguan tidur. Pengobatannya meliputi terapi kognitif-perilaku, relaksasi, olahraga, dan, jika diperlukan, obat antianxiety.', 'Penderita anxiety sering merasa gelisah, tegang, atau kesulitan untuk fokus. Gejala fisiknya bisa mencakup detak jantung yang cepat, berkeringat, gemetar, dan gangguan tidur. Kecemasan yang terus-menerus ini dapat mengganggu aktivitas sehari-hari dan hubungan sosial.', 'Pengobatannya melibatkan kombinasi terapi, obat-obatan, dan perubahan gaya hidup. Terapi kognitif-perilaku (CBT) adalah salah satu pendekatan utama untuk membantu individu mengubah pola pikir dan perilaku yang menyebabkan kecemasan.'),
('penyakit_11.png', 'ASD', 'Autism Spectrum Disorder (ASD) adalah gangguan perkembangan saraf yang memengaruhi kemampuan individu dalam berinteraksi sosial, berkomunikasi, serta menunjukkan perilaku atau minat yang terbatas dan berulang. ASD dapat muncul sejak usia dini dan memengaruhi cara seseorang memahami dunia di sekitarnya.', 'Gejalanya bervariasi, namun umumnya mencakup kesulitan dalam memahami atau merespons isyarat sosial, keterlambatan dalam berbicara, serta minat atau perilaku yang terbatas dan berulang. Anak dengan ASD mungkin menunjukkan kecenderungan untuk mengikuti rutinitas tertentu dan sangat sensitif terhadap rangsangan seperti suara atau cahaya.', 'Pengobatannya meliputi terapi perilaku, terapi wicara, pendekatan pendidikan terstruktur, serta obat-obatan untuk mengelola gejala tertentu. Dukungan keluarga juga penting dalam proses pengobatan.'),
('penyakit_3.png', 'Bipolar', 'Bipolar adalah gangguan mental yang ditandai oleh perubahan suasana hati yang ekstrem, yaitu antara episode mania (atau hipomania) dan depresi. Dalam episode mania, seseorang merasa sangat energik, penuh semangat, atau bahkan mudah tersinggung, sementara dalam episode depresi, mereka merasa sangat sedih, kehilangan minat, dan rendah energi. Gangguan ini bersifat kronis dan memengaruhi cara seseorang berpikir, merasakan, dan berperilaku dalam kehidupan sehari-hari.\r\n\r\n', 'Gejala bipolar meliputi episode mania, seperti merasa sangat bahagia, energik, bicara cepat, dan impulsif, serta episode depresi, seperti merasa sedih, kehilangan minat, kelelahan, dan pikiran tentang bunuh diri. ', 'Pengobatannya mencakup penggunaan obat-obatan, seperti stabilisator suasana hati, antipsikotik, atau antidepresan, serta terapi psikologis, seperti CBT dan terapi interpersonal. Gaya hidup sehat, menjaga pola tidur, mengelola stres, dan dukungan sosial juga penting. Pada kasus parah, rawat inap mungkin diperlukan untuk stabilisasi. Dukungan dan pengobatan yang tepat dapat membantu penderita bipolar menjalani hidup dengan baik.'),
('penyakit_7.png', 'BPD', 'Borderline Personality Disorder (BPD) adalah gangguan kepribadian yang ditandai dengan ketidakstabilan emosi, hubungan interpersonal, dan citra diri. ', 'Gejalanya meliputi perubahan suasana hati yang intens, ketakutan akan penolakan atau ditinggalkan, hubungan yang tidak stabil, perasaan hampa, perilaku impulsif, serta kesulitan mengendalikan kemarahan. Orang dengan BPD juga sering merasa tidak tahu siapa diri mereka sebenarnya dan mungkin memiliki perilaku merusak diri.', 'Pengobatan BPD berfokus pada terapi psikologis seperti Dialectical Behavior Therapy (DBT), terapi berbasis mentalisasi (MBT), dan terapi perilaku kognitif (CBT) untuk membantu mengelola emosi dan memperbaiki hubungan. Obat-obatan seperti antidepresan atau stabilisator suasana hati mungkin digunakan untuk meredakan gejala tertentu. Selain itu, pengelolaan gaya hidup, seperti menjaga rutinitas sehat, menghindari alkohol, dan meningkatkan keterampilan mengelola stres, sangat penting. Dukungan sosia'),
('penyakit_12.png', 'Delusi', 'Delusi adalah keyakinan yang salah dan tidak realistis yang diyakini dengan sangat kuat meskipun bukti yang ada bertentangan dengan keyakinan tersebut. Delusi merupakan salah satu gejala utama dalam gangguan mental seperti skizofrenia, gangguan delusi, dan gangguan bipolar. Penderita delusi sering kali terperangkap dalam pikiran yang tidak logis dan bisa mempengaruhi cara mereka berinteraksi dengan orang lain atau menjalani kehidupan sehari-hari.', 'Gejala delusi meliputi keyakinan yang salah dan tidak realistis, seperti delusi persekusi (percaya bahwa orang lain berusaha menyakiti mereka), delusi grandiositas (percaya memiliki kemampuan atau kekuasaan luar biasa), delusi refleksif (percaya bahwa orang lain membicarakan mereka), dan delusi kontrol (percaya bahwa pikiran atau tindakan mereka dikendalikan oleh kekuatan eksternal).', 'Pengobatan delusi melibatkan terapi kognitif-perilaku (CBT) untuk membantu penderita mengenali ketidaklogisan dari delusi mereka, serta penggunaan antipsikotik untuk menstabilkan bahan kimia otak yang berperan dalam gejala tersebut. Dukungan sosial dari keluarga dan teman juga sangat penting untuk membantu proses pemulihan.'),
('penyakit_1.png', 'Depresi', 'Gangguan suasana hati yang ditandai dengan perasaan sedih berkepanjangan, kehilangan minat atau kesenangan, serta penurunan energi. Depresi dapat mempengaruhi kemampuan seseorang untuk berfungsi dalam kehidupan sehari-hari.', 'Seseorang yang depresi umumnya menunjukkan ciri-ciri psikologi dan fisik tertentu. Ciri psikologis orang yang depresi adalah rasa cemas dan khawatir yang berlebihan, emosi yang tidak stabil, serta rasa putus asa atau frustasi.\r\nSementara itu, ciri-ciri fisik pada seseorang yang depresi adalah selalu merasa salah dan tak bertenaga, pusing dan nyeri tanpa penyebab yang jelas, serta menurunnya selera makan.', 'Melakukan psikoterapi atau terapi psikologis, untuk membantu mengatasi masalah akibat depresi\r\n\r\nMemberikan obat antidepresan, untuk mengatasi depresi pasien\r\n\r\nMenjalani perawatan di rumah sakit jika mengalami depresi yang parah'),
('penyakit_4.png', 'Gangguan Makan', 'Gangguan makan adalah kondisi serius yang melibatkan pola makan yang tidak sehat atau berlebihan, yang dapat memengaruhi fisik, emosional, dan psikologis seseorang. Gangguan ini termasuk anoreksia nervosa, bulimia nervosa, dan gangguan makan berlebihan (binge eating), yang sering kali terkait dengan perasaan rendah diri, stres, atau gangguan citra tubuh.', 'Gejala gangguan makan meliputi anoreksia nervosa yang ditandai dengan penurunan berat badan ekstrem, pembatasan makanan yang ketat, dan ketakutan berlebihan terhadap kenaikan berat badan; bulimia nervosa yang melibatkan episode makan berlebihan yang diikuti dengan perilaku kompensasi seperti muntah atau penggunaan obat pencahar; dan gangguan makan berlebihan yang ditandai dengan makan dalam jumlah besar tanpa kontrol, tetapi tanpa perilaku kompensasi.', 'Pengobatan gangguan makan melibatkan terapi perilaku kognitif (CBT) untuk mengubah pola pikir dan perilaku yang merusak, pemberian obat antidepresan untuk mengatasi kecemasan atau depresi terkait, serta pendidikan gizi untuk membantu penderita membangun pola makan yang sehat. Dukungan sosial, seperti kelompok dukungan atau terapi keluarga, juga penting untuk proses pemulihan.'),
('penyakit_10.png', 'Insomnia', 'Insomnia adalah gangguan tidur yang ditandai dengan kesulitan tidur atau mempertahankan tidur meskipun memiliki kesempatan untuk tidur. Penderita insomnia sering merasa tidak segar atau lelah setelah bangun tidur, yang dapat memengaruhi kualitas hidup dan fungsi sehari-hari mereka.\r\n\r\n', 'Gejala insomnia meliputi kesulitan untuk tidur atau mempertahankan tidur, sering terbangun di tengah malam, tidur yang tidak nyenyak, serta merasa lelah dan mengantuk pada siang hari. Penderita juga mungkin mengalami kesulitan berkonsentrasi atau perubahan mood akibat kurang tidur.', 'Pengobatan insomnia mencakup perubahan gaya hidup, seperti menjaga rutinitas tidur yang konsisten dan menghindari kafein sebelum tidur, serta terapi kognitif-perilaku (CBT-I) untuk membantu mengatasi pola pikir yang mengganggu tidur. Obat tidur dapat digunakan untuk jangka pendek, namun manajemen stres melalui teknik relaksasi dan yoga juga penting untuk mendukung kualitas tidur yang lebih baik.'),
('penyakit_8.png', 'OCD', 'Obsessive-Compulsive Disorder (OCD) adalah gangguan mental yang ditandai dengan adanya obsesi (pikiran, dorongan, atau gambar yang mengganggu dan tidak diinginkan) dan kompulsi (perilaku berulang atau tindakan mental yang dilakukan untuk mengurangi kecemasan akibat obsesi tersebut). Penderita OCD merasa terjebak dalam pola pikir dan tindakan yang berulang, meskipun mereka sadar bahwa perilaku tersebut tidak rasional.', '\r\nGejala OCD meliputi obsesi berupa pikiran atau gambar yang mengganggu dan menimbulkan kecemasan, serta kompulsi berupa perilaku berulang, seperti mencuci tangan berlebihan atau memeriksa sesuatu secara terus-menerus untuk meredakan kecemasan tersebut. Penderita juga merasa tertekan jika tidak melakukan ritual tertentu.', 'Pengobatan OCD melibatkan terapi perilaku kognitif (CBT) dengan teknik exposure and response prevention untuk membantu pasien mengurangi kompulsi, serta obat antidepresan seperti SSRI yang dapat mengurangi gejala dengan mempengaruhi kadar serotonin di otak. Mengelola stres dan menjaga rutinitas hidup yang sehat juga penting dalam mendukung pengobatan.'),
('penyakit_9.png', 'PTSD', 'Post-Traumatic Stress Disorder (PTSD) adalah gangguan mental yang berkembang setelah seseorang mengalami atau menyaksikan peristiwa traumatis atau mengancam jiwa, seperti kecelakaan, kekerasan, atau bencana alam. Penderita PTSD dapat mengalami gejala yang mengganggu kehidupan sehari-hari mereka, termasuk kilas balik (flashback), mimpi buruk, kecemasan yang parah, dan kesulitan mengendalikan emosi.', 'Gejala PTSD meliputi kilas balik yang mengingatkan pada peristiwa traumatis, mimpi buruk, kecemasan berlebihan, dan kesulitan tidur. Penderita juga mungkin menghindari situasi atau orang yang mengingatkan mereka pada trauma, serta mengalami perasaan tertekan, kehilangan minat, dan kewaspadaan yang meningkat.', 'Pengobatan PTSD melibatkan terapi psikologis seperti CBT atau EMDR untuk membantu mengelola trauma, serta penggunaan antidepresan untuk mengurangi gejala kecemasan dan depresi. Terapi pendedahan juga dapat membantu pasien menghadapi ingatan traumatis secara bertahap. Dukungan sosial dan manajemen stres melalui teknik relaksasi, seperti meditasi, juga penting dalam proses pemulihan.'),
('penyakit_5.png', 'Skizofrenia', 'Skizofrenia adalah gangguan mental serius yang mempengaruhi cara seseorang berpikir, merasa, dan bertindak. Penderita skizofrenia sering kali kehilangan kontak dengan kenyataan, yang dapat mengarah pada halusinasi, delusi, dan pikiran yang kacau. Gangguan ini bisa sangat memengaruhi kehidupan sehari-hari, termasuk kemampuan untuk bekerja, berinteraksi sosial, dan menjaga hubungan pribadi yang sehat.', 'Gejala skizofrenia meliputi halusinasi seperti mendengar suara-suara atau melihat hal-hal yang tidak ada, delusi seperti percaya pada ide yang tidak realistis, serta berbicara atau berperilaku kacau. Penderita juga dapat mengalami gejala negatif seperti kehilangan minat dalam kegiatan sehari-hari, kesulitan berinteraksi sosial, dan kurangnya ekspresi emosi. Selain itu, gejala kognitif dapat mencakup kesulitan berkonsentrasi atau mengingat serta penyusutan kemampuan untuk merencanakan atau mengor', 'Pengobatan skizofrenia melibatkan penggunaan antipsikotik untuk mengontrol halusinasi dan delusi, serta terapi psikologis seperti CBT untuk membantu pasien mengelola gejala dan meningkatkan keterampilan sosial. Dukungan keluarga dan terapi keluarga juga penting untuk membantu pemulihan, sementara gaya hidup sehat, termasuk pengelolaan stres dan tidur yang baik, dapat mendukung proses penyembuhan.');

-- --------------------------------------------------------

--
-- Table structure for table `psikiater`
--

CREATE TABLE `psikiater` (
  `foto_ahli` varchar(50) NOT NULL,
  `nama_ahli` varchar(50) NOT NULL,
  `spesialis` varchar(55) DEFAULT NULL,
  `jam_kerja` time NOT NULL,
  `pengalaman` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `psikiater`
--

INSERT INTO `psikiater` (`foto_ahli`, `nama_ahli`, `spesialis`, `jam_kerja`, `pengalaman`) VALUES
('zubaidah.jpg', 'Zubaidah Watullo M.Psi', 'Psikolog  Perkerjaan & Karir, trauma', '00:30:00', '4 Tahun');

-- --------------------------------------------------------

--
-- Table structure for table `schedule`
--

CREATE TABLE `schedule` (
  `username` varchar(50) DEFAULT NULL,
  `nama_ahli` varchar(50) DEFAULT NULL,
  `jadwal_konseling` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tips`
--

CREATE TABLE `tips` (
  `gambar` varchar(255) NOT NULL,
  `nama_tips` char(50) NOT NULL,
  `penjelasan` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tips`
--

INSERT INTO `tips` (`gambar`, `nama_tips`, `penjelasan`) VALUES
('tips_3.png', 'Jangan malu berkonsultasi', 'Jangan malu untuk berkonsultasi dengan profesional jika Anda mengalami gangguan kesehatan mental.Beberapa gangguan kesehatan mental yang dapat diatasi dengan konsultasi ke profesional adalah: Depresi, Insomnia, Masalah mental lainnya, Stres yang tidak terkendali, Gangguan emosi.'),
('tips_1.png', 'Kelola stres', 'Tidak semua stres itu buruk. Namun, stres jangka panjang dapat menyebabkan masalah kesehatan, seperti penyakit jantung, obesitas, tekanan darah tinggi, dan depresi. Dengan mengelola stres, kesehatan mental Anda akan lebih mungkin terjaga. Cobalah kelola stres dengan cara berolahraga setiap hari, menyisihkan waktu untuk diri sendiri, menjaga pola makan, tidur yang cukup, serta hindari alkohol dan obat-obatan.'),
('tips_4.png', 'Olahraga', 'Olahraga dapat membantu menjaga kesehatan mental dengan meningkatkan produksi endorfin, hormon yang dapat meningkatkan suasana hati.\r\n'),
('tips_5.png', 'Terbukalah pada Seseorang', 'Berbicara tentang penyakit mental bisa menjadi langkah penting untuk mendapatkan dukungan. Pilihlah seseorang yang Anda percaya, seperti teman, keluarga, atau tenaga profesional, dan mulailah dengan menceritakan hal-hal yang membuat Anda nyaman. Jika sulit berbicara langsung, tuliskan perasaan Anda dalam surat atau catatan. Gunakan kata-kata sederhana tanpa merasa harus menjelaskan segalanya sekaligus, dan ingat bahwa menangis adalah hal wajar. Jangan terburu-buru; berbagi bisa dilakukan secara bertahap. Jika dukungan dari orang terdekat dirasa kurang, konsultasikan langsung dengan profesional kesehatan mental yang siap membantu. Membuka diri adalah langkah pertama menuju pemulihan, dan Anda layak mendapatkannya. 🌱'),
('tips_2.png', 'Tetapkan tujuan yang realistis', 'langkah penting untuk mencapai kemajuan tanpa merasa terbebani. Mulailah dengan mengenali kemampuan dan batasan diri, lalu pecah tujuan besar menjadi langkah-langkah kecil yang lebih mudah dicapai. Pastikan tujuan tersebut spesifik, terukur, dan memiliki waktu yang jelas untuk dicapai. Fokuslah pada proses, bukan hanya hasil akhir, dan bersiaplah untuk menyesuaikan tujuan jika situasi berubah. Dengan begitu, Anda tetap termotivasi dan dapat menikmati setiap pencapaian kecil yang mendekatkan Anda pada hasil yang diinginkan.'),
('tips_6.png', 'Tidur Tepat Waktu', 'Tidur yang berkualitas dapat membantu mengatasi stres dan gangguan pola tidur.');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(10) NOT NULL,
  `email` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`username`, `password`, `email`) VALUES
('admin', 'admin', 'admin@gmail.com'),
('ardiganteng', 'ardi1234', 'ardi@gmail.com');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `kegiatan`
--
ALTER TABLE `kegiatan`
  ADD KEY `username` (`username`);

--
-- Indexes for table `penyakit`
--
ALTER TABLE `penyakit`
  ADD PRIMARY KEY (`jenis_penyakit`);

--
-- Indexes for table `psikiater`
--
ALTER TABLE `psikiater`
  ADD PRIMARY KEY (`nama_ahli`);

--
-- Indexes for table `schedule`
--
ALTER TABLE `schedule`
  ADD KEY `username` (`username`),
  ADD KEY `nama_ahli` (`nama_ahli`);

--
-- Indexes for table `tips`
--
ALTER TABLE `tips`
  ADD PRIMARY KEY (`nama_tips`),
  ADD KEY `nama_tips` (`nama_tips`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`username`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `kegiatan`
--
ALTER TABLE `kegiatan`
  ADD CONSTRAINT `kegiatan_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
